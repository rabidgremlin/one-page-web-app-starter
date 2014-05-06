package com.rabidgremlin.onepagewebstarter.resources;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.google.inject.Guice;
import com.rabidgremlin.onepagewebstarter.guice.GuiceModule;


public class MyApplication extends ResourceConfig {

	@Inject
	public MyApplication(ServiceLocator serviceLocator) {
		packages("com.rabidgremlin.onepagewebstarter.resources");

		System.out.println("Registering injectables...");

		GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

		GuiceIntoHK2Bridge guiceBridge = serviceLocator
				.getService(GuiceIntoHK2Bridge.class);
		guiceBridge
				.bridgeGuiceInjector(Guice.createInjector(new GuiceModule()));
	}
}
