package com.rabidgremlin.onepagewebstarter.guice;

import com.google.inject.AbstractModule;
import com.rabidgremlin.onepagewebstarter.doa.TodoDoa;

public class DaoModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TodoDoa.class);
		
	}

}
