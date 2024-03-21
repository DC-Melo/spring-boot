# sping-boot-hello-world #

In this article, we will show you a simple sping boot web application, publish an endpoint /, and access it, and the endpoint will return
a string <b>hello world</b> as a result.


Technologies used:
java:17
spring-boot:3.2.3
Maven:3.9.5
> Note
> Spring Boot 3.x requires Java 17.

## Project initialization ##

We use web as the dependencies to initialise the project.
```bash
spring init --build=maven --java-version=17 --dependencies=web --package-name=com.dc spring-boot-hello-world
```



