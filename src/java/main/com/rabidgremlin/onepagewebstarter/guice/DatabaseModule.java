package com.rabidgremlin.onepagewebstarter.guice;

import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.rabidgremlin.onepagewebstarter.util.AppConfig;

public class DatabaseModule extends AbstractModule
{
  private AppConfig appConfig;

  public DatabaseModule(AppConfig appConfig)
  {
	super();
	this.appConfig = appConfig;
  }

  @Override
  protected void configure()
  {
	JpaPersistModule jpa = new JpaPersistModule("onepagestarter");

	Properties props = new Properties();

	props.put(
	    "javax.persistence.jdbc.url",
	    String.format("jdbc:mysql://%s:%s/%s", appConfig.getProperty("db.host"), appConfig.getProperty("db.port"),
	        appConfig.getProperty("db.name")));
	props.put("javax.persistence.jdbc.user", appConfig.getProperty("db.name"));
	props.put("javax.persistence.jdbc.password", appConfig.getProperty("db.password"));

	jpa.properties(props);
	jpa.configure(binder());
  }

}
