# my-actuator

## To enable Spring Boot Actuator, we just need to add the spring-boot-actuator dependency to our package manager.

# pom.xml:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

By default, health endpoint will we enabled, If you want to enable more nedpoint use below property.
management.endpoints.web.exposure.include=info,...
or
management.endpoints.web.exposure.include=*

Detailed view of health
management.endpoint.health.show-details:always

The /actuator endpoint reports all available actuator endpoints under the _links field.
localhost:8080/actuator

Moreover, if we configure a custom management base path, then we should use that base path as the discovery URL.
server.servlet.context-path=/api
localhost:8080/api/actuator

For instance, if we set the management.endpoints.web.base-path=/mgmt, then we should send a request to the /mgmt endpoint to see the list of links.
management.endpoints.web.base-path=/mgmt
localhost:8080/api/mgmt

## To check app health
localhost:8080/api/mgmt/health
{
"status": "UP"
}

## Custom actuator endpoint
Create your own custom endpoint and add endpoint to this property to use.
management.endpoints.web.exposure.include=health, info, *custom*

## custom indicators
custom indicators easily. Opposite to other APIs, the abstractions for creating custom health endpoints remain unchanged. However, a new interface, ReactiveHealthIndicator, has been added to implement reactive health checks.

## Customize health endpoint
https://www.amitph.com/custom-health-check-spring-boot-actuator/


# info endpoint
info - will return the build details.

Add/Modify below plugin
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
<executions>
<execution>
<goals>
<goal>build-info</goal>
</goals>
</execution>
</executions>
</plugin>

localhost:8080/api/mgmt/info
{
"build": {
"version": "0.0.1-SNAPSHOT",
"artifact": "actuator",
"name": "actuator",
"group": "com.example",
"time": "2022-07-23T09:28:08.781Z"
}
}


# Shutdown endpoint
management.endpoints.web.exposure.include=custom, health, info, shutdown
management.endpoint.shutdown.enabled=true

localhost:8080/api/mgmt/shutdown
{
"message": "Shutting down, bye..."
}


# We need to add the following configuration to expose all endpoints:
management.endpoints.web.exposure.include=*

# To expose all enabled endpoints except one (e.g., /loggers), we use:
management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.exclude=loggers

## Run Actuator in different port
For security purposes, we might choose to expose the actuator endpoints over a non-standard port
management.server.port=8081
