package com.rabidgremlin.onepagewebstarter.guice;

import com.google.inject.servlet.SessionScoped;

@SessionScoped
public class Service {

	private int i = 0;

	public Service() {}

	public String get() {
		return i++ + " got it from guice service";
	}

}
