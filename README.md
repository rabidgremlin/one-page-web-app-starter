# One page web app starter

A "starter" project for building a one-page-web app using AngularJS, Bootstrap, ApacheCXF and Hibernate.


## Build a release

1. Prerequisites

* Ant 1.9.3 or >
* JDK 1.7 or >
* MySql 5.5 or >
* App source: clone repo or download source .zip 

2. Download dependencies and create user properties file
```
    cd build
    ant init
```	
Should download all dependencies and then report an error wrt a missing properties files. Create this file in ```build``` folder

3. 	Build release
```
    ant release
```	
A .zip	file will be created in the ```release``` folder
	
## Deploying a release
App should work with any modern servlet engine. Steps to deploy are:

1. Create an etc folder and place folders from _/etc_ folder of zip into it
2. Edit the files in etc folder changing paths, passworsd etc
3. Use database scripts found in /sql to create the database
4. Copy the opwas.war file into your container's web apps folder
5. Configure your container with a system property named _opwas.config.file_ and set it to the location of the opwas.properties file


## Development in Eclipse 
1. Create a build using Ant as above to ensure environment is set up

2. Install Eclipse Jetty Integration via the Eclipse Marketplace http://eclipse-jetty.sourceforge.net/

3. Import project

4. Right click project, select run as, run with jetty. You will need to ensure that you set a -Dopwas.config.file VM parameter pointing at src/etc/opwas.properties file for run configuration

5. Browse to http://localhost:8080/

