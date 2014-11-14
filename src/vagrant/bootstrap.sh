#!/usr/bin/env bash

apt-get update

# Install mysql
export DEBIAN_FRONTEND=noninteractive
apt-get -q -y install mysql-server

# set up database
mysql -vv < /vagrant/sql/createdb.sql

# Install Java 
apt-get install -y openjdk-7-jdk

# make logs dir
mkdir /vagrant/logs 

# Install jetty 8 not using ubuntu package because it's JSP support is broken
cd /tmp
tar -xvf /vagrant/jetty-distribution-8.1.16.v20140903.tar.gz
mv jetty-distribution-8.1.16.v20140903 /opt/jetty

# configure jetty 
echo "NO_START=0" > /etc/default/jetty
echo "JETTY_HOST=0.0.0.0" >> /etc/default/jetty
echo "JETTY_PORT=8080" >> /etc/default/jetty
echo "JETTY_HOME=/opt/jetty" >> /etc/default/jetty
echo "JETTY_LOGS=/vagrant/logs" >> /etc/default/jetty
echo 'JAVA_OPTIONS="-Xmx256m -Djava.awt.headless=true -Dopwas.config.file=/opt/opwas/etc/opwas.properties"' >> /etc/default/jetty

# set up jetty init script
cp /vagrant/jettyinitscript /etc/init.d/jetty
chown root:root /etc/init.d/jetty
chmod 744 /etc/init.d/jetty

# set up app
cp /vagrant/opwas.war /opt/jetty/webapps/
mkdir /opt/opwas/
mkdir /opt/opwas/etc
cp /vagrant/etc/* /opt/opwas/etc/

service jetty restart




