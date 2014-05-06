package com.rabidgremlin.onepagewebstarter.guice;

import com.google.inject.servlet.ServletModule;

public class GuiceModule extends ServletModule {

	@Override
	protected void configureServlets() {
		bind(Service.class);
	}

}
