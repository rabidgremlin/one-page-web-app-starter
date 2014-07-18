package com.rabidgremlin.onepagewebstarter.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.rabidgremlin.onepagewebstarter.util.AppConfig;

public class AppConfigModule extends AbstractModule
{  
  private AppConfig appConfig;

  public AppConfigModule(AppConfig appConfig)
  {
	super();
	this.appConfig = appConfig;
  }

  @Override
  protected void configure()
  {
	// do nothing
  }

  @Provides
  @Singleton
  AppConfig provideAppConfigr()
  {
	return appConfig;
  }
}
