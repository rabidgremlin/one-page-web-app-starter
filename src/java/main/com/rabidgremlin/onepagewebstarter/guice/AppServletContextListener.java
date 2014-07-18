/* 
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package com.rabidgremlin.onepagewebstarter.guice;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.xml.DOMConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.rabidgremlin.onepagewebstarter.util.AppConfig;

public class AppServletContextListener extends GuiceServletContextListener
{
  /**
   * The app config file key. This is value should be set as a -D param on the
   * JVM pointing at the config file for the app.
   */
  private static final String APP_CONFIG_FILE_KEY = "opwas.config.file";
  public static final String PROPERTY_LOG_CONFIG = "log.config.file";

  @Override
  protected Injector getInjector()
  {
	// load the app config
	AppConfig appConfig = new AppConfig(APP_CONFIG_FILE_KEY);

	// init log4j
	try
	{

	  // check that log config property is specified
	  if (StringUtils.isBlank(appConfig.getPropertiesConfiguration().getString(PROPERTY_LOG_CONFIG)))
	  {
		throw new Exception("Property '" + PROPERTY_LOG_CONFIG + "' must be specified in properties file");
	  }

	  String log4JFileName = appConfig.getFile(PROPERTY_LOG_CONFIG).getAbsolutePath();
	  System.out.println("Loading log4j configuration from: " + log4JFileName);

	  // configure an application logging
	  DOMConfigurator.configure(log4JFileName);
	}
	catch (Exception e)
	{
	  System.err.println("Cannot initialise logging: " + e.getMessage());
	  throw new RuntimeException(e);
	}

	// set up injector
	return Guice.createInjector(new AppConfigModule(appConfig), new DatabaseModule(appConfig), new ServletModule()
	{

	  @Override
	  protected void configureServlets()
	  {
		Map<String, String> params = new HashMap<String, String>();
		params
		    .put(
		        "jaxrs.serviceClasses",
		        "com.rabidgremlin.onepagewebstarter.rest.resources.TodosResource,com.rabidgremlin.onepagewebstarter.rest.resources.PingResource");
		params.put("jaxrs.providers", "org.codehaus.jackson.jaxrs.JacksonJsonProvider");
		serve("/api/*").with(CxfGuiceServlet.class, params);

		filter("/api/*").through(PersistFilter.class);

		bind(net.sf.packtag.servlet.PackServlet.class).in(Singleton.class);
		serve("*.pack").with(net.sf.packtag.servlet.PackServlet.class);
	  }
	});

  }

}
