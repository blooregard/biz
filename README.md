# Description
This is the application that we made in the JSF Training course

## Components
* JSF 2.1.9
* Maven 3.0.4
* Java 1.7
* Guava
* JUnit
* Joda-Time
* Spring 3.2.1
* HSQL

## Purpose
Collect business user data for creation and display


## Running
This can be run from your IDE or Maven
* Eclipse

* IntelliJ

* Maven 
> mvn tomcat7:run-war

## HSQL setup
* Start HSQL in server mode

> java -cp ..\..\devtools\apache-maven-3.0.4\repo\org\hsqldb\hsqldb\2.2.9\hsqldb-2.2.9.jar org.hsqldb.Server -database.0 file:licenses -dbname.0 licenses
* Start HSQL Swing browser

> java -cp ..\..\devtools\apache-maven-3.0.4\repo\org\hsqldb\hsqldb\2.2.9\hsqlb-2.2.9.jar org.hsqldb.util.DatabaseManager
From the Manager

> File \> Connect \> Change Type to Server \> Modify URL to jdbc:hsqldb:hsql://localhost/licenses
