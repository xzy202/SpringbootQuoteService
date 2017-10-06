# Overview

The Quote application is a simple website that serves a random quote to the
user.  The application is seeded with a few quotes and more can be added via the "Add" link on the bottom left.

## Getting Started with the Application

### Github
The Quote application can be found at this Github repository -

https://github.com/mis-iccfb-primary/quote-app-monolith

You should fork this repository and clone your copy from Github.  You will
be working out of your copy at this point.

### Gradle
The application is built using Gradle.  You can read more about Gradle here -

https://gradle.org/

The application's repository contains a Gradle Wrapper file that you will use
to get started.  When you issue a build command, the Gradle Wrapper will
automatically download the appropriate version of Gradle and start the build.
The build will then download all the required dependencies for the application.

To build issue this command -

    ./gradlew build

After the build, you can run the application using the following command -

    java -jar ./build/libs/Quote-0.0.1-SNAPSHOT.jar

Browse to http://localhost:8080 to view the application.

### Eclipse

The Eclipse for Java Developers allows you to import a Gradle project.  Click File and select Import to get started.  Follow the Import Gradle Project instructions.  After selecting the root directory, you can accept the defaults on the other screens.

You can run the application from Eclipse by right clicking the QuoteApplication.java file and selecting "Run As -> Java Application".

Browse to http://localhost:8080 to view the application.

# The Tech Stack

## Spring Boot

Spring Boot is used to provide the web (Model View Controller) framework for the application.  You can read more about Spring Boot [here](https://projects.spring.io/spring-boot/)

## H2

H2 is used to provide an in memory database for our development.  Since the database is in memory, the data will be lost when the application stops.  This obviously isn't ideal in production but is OK for development.

You can read more about H2 [here](http://www.h2database.com/html/main.html)

## AngularJS

AngularJS is a very popular Javascript framework to create dynamic web applications. You can read more about AngularJS [here](https://angularjs.org/)
