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

The original example used the Jetty servlet container which if migrated as is requires a separate port to the tomcat container used by default by Spring Boot. This migrated example keeps things simple and reuses the tomcat servlet container available via the following pom dependencies:

    cxf-spring-boot-starter-jaxws  <-- defined in the server/pom.xml
      spring-boot-starter-web      <-- this and those below are the transitive dependencies
        spring-boot-starter-tomcat

If you wish to use a different servlet container (such as Undertow) then this is documented here

https://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-servlet-containers.html#howto-use-undertow-instead-of-tomcat

Also note that the client and server are now separate Spring Boot applications, this matches a micro services architecture where they would be deployed separately.

Logging has been simplified and now leverages the default logging configuration in Spring Boot, this can be customized following this documentation

https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html



