package com.rabidgremlin.onepagewebstarter.guice;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class AppServletContextListener extends GuiceServletContextListener {

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
	 * @Override protected void configureServlets() { Map<String, String> params
	 * = new HashMap<String, String>();
	 * params.put(PackagesResourceConfig.PROPERTY_PACKAGES,
	 * "com.rabidgremlin.onepagewebstarter.rest.resources");
	 * params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
	 * serve("/api/*").with(GuiceContainer.class, params); } }); }
	 */

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {

			@Override
			protected void configureServlets() {
				install(new JpaPersistModule("onepagestarter"));

				Map<String, String> params = new HashMap<String, String>();
				params.put("jaxrs.serviceClasses", "com.rabidgremlin.onepagewebstarter.rest.resources.TodosResource,com.rabidgremlin.onepagewebstarter.rest.resources.PingResource");
				params.put("jaxrs.providers", "org.codehaus.jackson.jaxrs.JacksonJsonProvider");
				serve("/api/*").with(CxfGuiceServlet.class, params);

				filter("/api/*").through(PersistFilter.class);
			}
		});
	}

}
