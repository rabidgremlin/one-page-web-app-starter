package com.rabidgremlin.onepagewebstarter.guice;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class AppServletContextListener extends GuiceServletContextListener
{

  @Override
  protected Injector getInjector()
  {
	return Guice.createInjector(new JerseyServletModule()
	{
	  @Override
	  protected void configureServlets()
	  {
		Map<String, String> params = new HashMap<String, String>();
		params.put(PackagesResourceConfig.PROPERTY_PACKAGES, "com.rabidgremlin.onepagewebstarter.rest.resources");
		params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
		serve("/api/*").with(GuiceContainer.class, params);
	  }
	});
  }
}
