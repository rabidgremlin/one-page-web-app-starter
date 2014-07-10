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

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class AppServletContextListener extends GuiceServletContextListener
{

  /*
   * @Override protected Injector getInjector() { return
   * Guice.createInjector(new ServletModule() {
   * 
   * @Override protected void configureServlets() { install(new
   * JpaPersistModule("onepagestarter")); // like we saw // earlier.
   * 
   * filter("/api/*").through(PersistFilter.class); } }, new
   * JerseyServletModule() {
   * 
   * @Override protected void configureServlets() { Map<String, String> params =
   * new HashMap<String, String>();
   * params.put(PackagesResourceConfig.PROPERTY_PACKAGES,
   * "com.rabidgremlin.onepagewebstarter.rest.resources");
   * params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
   * serve("/api/*").with(GuiceContainer.class, params); } }); }
   */

  @Override
  protected Injector getInjector()
  {
	return Guice.createInjector(new ServletModule()
	{

	  @Override
	  protected void configureServlets()
	  {
		install(new JpaPersistModule("onepagestarter"));

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
