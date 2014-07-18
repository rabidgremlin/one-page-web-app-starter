package com.rabidgremlin.onepagewebstarter.util;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

public class AppConfig
{
  private PropertiesConfiguration configuration;

  public AppConfig(String appConfigFilePathKey)
  {
	// log it
	System.out.println("App config file path key is: " + appConfigFilePathKey);

	// get the config file location
	String configPath = System.getProperty(appConfigFilePathKey);

	try
	{
	  // log to system out as logging may not be set up at this point
	  System.out.println("Loading configuration from: " + configPath);

	  configuration = new PropertiesConfiguration(configPath);
	  configuration.setReloadingStrategy(new FileChangedReloadingStrategy());

	}
	catch (Exception e)
	{
	  System.err.println("Cannot initialise the AppConfig: " + e.getMessage());
	  throw new RuntimeException(e);
	}
  }

  /**
   * Builds the relative file path.
   * 
   * @param config
   *          the config
   * @param fileName
   *          the file name
   * @return the file
   * @throws ConfigurationException
   *           the configuration exception
   */
  private File buildRelativeFilePath(PropertiesConfiguration config, String fileName) throws ConfigurationException
  {
	File theFile = ConfigurationUtils.getFile(config.getBasePath(), fileName);

	if (theFile == null)
	{
	  throw new ConfigurationException("Cannot resolve relative file " + fileName);
	}

	return theFile;
  }

  /**
   * Gets the file specified by the key. The file can be specified with an
   * absolute path or a path relative to the apps configuration path.
   * 
   * @param key
   *          The key.
   * @return The file.
   * @throws ConfigurationException
   *           Thrown if the file name cannot be determined.
   */
  public File getFile(String key) throws ConfigurationException
  {
	return buildRelativeFilePath(configuration, getProperty(key));
  }

  /**
   * Return a configuration property value by key.
   * 
   * @param key
   *          a property key
   * @return a property value
   */
  public String getProperty(String key)
  {
	return configuration.getString(key, "");
  }
  
  public PropertiesConfiguration getPropertiesConfiguration()
  {
	return configuration;
  }
}
