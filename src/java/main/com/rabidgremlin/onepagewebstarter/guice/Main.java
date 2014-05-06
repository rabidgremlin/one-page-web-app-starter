package com.rabidgremlin.onepagewebstarter.guice;

import org.glassfish.jersey.server.ResourceConfig;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.rabidgremlin.onepagewebstarter.resources.HelloResource;

public class Main extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() 
		//{
//			@Override
//			protected void configureServlets() {
//				// Must configure at least one JAX-RS resource or the
//				// server will fail to start.
//				bind(HelloResource.class);
//
//				// Route all requests through GuiceContainer
//				/*ResourceConfig rc = new PackagesResourceConfig(
//						"com.athaydes.web.server");
//				for (Class<?> resource : rc.getClasses()) {
//					bind(resource);
//				}*/
//
//				serve("/api/*").with(GuiceContainer.class);
//			}
//		}
		);
	}
}
