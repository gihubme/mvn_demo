### Custom Starter for GreetingLibrary with Spring Boot

#### Root project mvn_demo

In dependenyManagement section has spring-boot-starter-parent.

It lists following modules:

- greeter-library
- greeter-spring-boot-sample-app
- greeter-spring-boot-starter
- greeter-spring-boot-autoconfigure

#### Greeter-library

A simple library that takes in a greeting message. This message is defined via configuration parameters and has
different values depending on the supplied daytime value. The produced output is the configured greeting message.

#### Greeter-spring-boot-sample-app

A sample Spring Boot application demonstrates the usage of greeter-library with autoconfigure and starter modules. As
pluginManagment app has:

- spring-boot-maven-plugin

As a dependency the app has only:

- greeter-spring-boot-starter module.

#### Greeter-spring-boot-autoconfigure

Provides custom configuration for greeter-library with properties class and externalised property file. As dependencies
autoconfigure module has:

- spring-boot
- spring-boot-autoconfigure
- spring-boot-configuration-processor
- greeter-library

#### Greeter-spring-boot-starter

Only a starter pom to bring in the required for the use of greeter-library dependencies. As dependencies autoconfigure
module has:

- spring-boot-starter
- greeter-spring-boot-autoconfigure
- greeter-library

 

