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
    mvn -pl client spring-boot:run
