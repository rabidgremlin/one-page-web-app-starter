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

## Vagrant environment
The project includes config files to run the app under Vagrant. To use them do the following:

1. Build a release of the app as detailed above
2. Install Vagrant from https://www.vagrantup.com/
3. Create a folder to run vagrant from (eg _opwas-vagrant_)
4. Copy the files from _src/vagrant_ into  _opwas-vagrant_
5. Download jetty 8.1.16 .tar.gz file and place into _opwas-vagrant_ http://eclipse.org/downloads/download.php?file=/jetty/stable-8/dist/jetty-distribution-8.1.16.v20140903.tar.gz&r=1
6. Copy the _etc_,_sql_ folders and _opwas.war_ from _release/files_ into _opwas-vagrant_
7. Edit _opwas-vagrant_/etc/log4j-opwas.xml and change ```/play/one-page-web-app-starter/tmp/opwas.log``` to ```/vagrant/logs```
8. From in _opwas-vagrant_ run ```vagrant up```
9. Once the VM is running browse to http://localhost:8080/opwas/

## Development in Eclipse 
1. Create a build using Ant as above to ensure environment is set up

2. Install Eclipse Jetty Integration via the Eclipse Marketplace http://eclipse-jetty.sourceforge.net/

3. Import project

4. Right click project, select run as, run with jetty. You will need to ensure that you set a -Dopwas.config.file VM parameter pointing at src/etc/opwas.properties file for run configuration

5. Browse to http://localhost:8080/

