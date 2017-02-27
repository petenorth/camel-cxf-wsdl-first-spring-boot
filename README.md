Introduction
------------

Decided to migrate 

https://github.com/tjsnell/camel-cxf-wsdl-first

To spring-boot and move from xml to annotation based config.

Build and Test
--------------

To test

    mvn clean install
    mvn -pl server spring-boot:run
    mvn -pl client spring-boot:run -Dserver.port=8081

Alterations
-----------

The original example used the Jetty servlet container which if migrated as is requires a separate port to the tomcat container used by default by Spring Boot. This migrated example keeps things simple and reuses the tomcat servlet container available via the X pom dependency. 
