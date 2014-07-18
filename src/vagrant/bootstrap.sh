#!/usr/bin/env bash

apt-get update

# Install Java 
apt-get install -y openjdk-7-jdk

# Install jetty
apt-get install -y jetty8

# configure jetty 
echo "NO_START=0" > /etc/default/jetty8
echo "JETTY_HOST=0.0.0.0" >> /etc/default/jetty8
echo "JETTY_PORT=8080" >> /etc/default/jetty8
echo "JAVA_HOME=/usr/lib/jvm/java-7-openjdk-i386/" >> /etc/default/jetty8
echo "JAVA_OPTIONS=\"-Xmx256m -Djava.awt.headless=true -Dopwas.config.file=/opt/opwas/etc/opwas.properties\""  >> /etc/default/jetty8


cp /vagrant/opwas.war /var/lib/jetty8/webapps/
mkdir /opt/opwas/
mkdir /opt/opwas/etc
mkdir /opt/opwas/logs
cp /vagrant/etc/* /opt/opwas/etc/

service jetty8 restart




