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

```bash
spring init --build=maven --java-version=17 --dependencies=web --package-name=com.dc spring-boot-hello-world
```

The spring-boot-starter-parent provide a base version for the Spring Boot applications. To develop web-related services, put spring-boot-starter-web.

## Project Dependencies in Tree Structure ##
For Spring boot 3, the spring-boot-starter-parent bring in the following main dependencies.
- Spring boot configuration stuff.
- Spring web mvc components.
- Embedded Tomcat 10.1.11.
- Slf4j logback for logging.
- Snakeyaml for external YAML properties.
- Jackson 2.x for JSON binding.

In maven we use mvn dependency:tree to review the project dependencies in a tree structure.
```bash
mvn dependency:tree
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< com.example:spring-boot-hello-world >-----------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- dependency:3.6.1:tree (default-cli) @ spring-boot-hello-world ---
[INFO] com.example:spring-boot-hello-world:jar:0.0.1-SNAPSHOT
[INFO] +- org.springframework.boot:spring-boot-starter-web:jar:3.2.3:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:3.2.3:compile
[INFO] |  |  +- org.springframework.boot:spring-boot:jar:3.2.3:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-autoconfigure:jar:3.2.3:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:3.2.3:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.4.14:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.4.14:compile
[INFO] |  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.21.1:compile
[INFO] |  |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.21.1:compile
[INFO] |  |  |  \- org.slf4j:jul-to-slf4j:jar:2.0.12:compile
[INFO] |  |  +- jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:2.2:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-json:jar:3.2.3:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.15.4:compile
[INFO] |  |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.15.4:compile
[INFO] |  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.15.4:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.15.4:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.15.4:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.15.4:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:3.2.3:compile
[INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:10.1.19:compile
[INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:10.1.19:compile
[INFO] |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:10.1.19:compile
[INFO] |  +- org.springframework:spring-web:jar:6.1.4:compile
[INFO] |  |  +- org.springframework:spring-beans:jar:6.1.4:compile
[INFO] |  |  \- io.micrometer:micrometer-observation:jar:1.12.3:compile
[INFO] |  |     \- io.micrometer:micrometer-commons:jar:1.12.3:compile
[INFO] |  \- org.springframework:spring-webmvc:jar:6.1.4:compile
[INFO] |     +- org.springframework:spring-aop:jar:6.1.4:compile
[INFO] |     +- org.springframework:spring-context:jar:6.1.4:compile
[INFO] |     \- org.springframework:spring-expression:jar:6.1.4:compile
[INFO] \- org.springframework.boot:spring-boot-starter-test:jar:3.2.3:test
[INFO]    +- org.springframework.boot:spring-boot-test:jar:3.2.3:test
[INFO]    +- org.springframework.boot:spring-boot-test-autoconfigure:jar:3.2.3:test
[INFO]    +- com.jayway.jsonpath:json-path:jar:2.9.0:test
[INFO]    |  \- org.slf4j:slf4j-api:jar:2.0.12:compile
[INFO]    +- jakarta.xml.bind:jakarta.xml.bind-api:jar:4.0.1:test
[INFO]    |  \- jakarta.activation:jakarta.activation-api:jar:2.1.2:test
[INFO]    +- net.minidev:json-smart:jar:2.5.0:test
[INFO]    |  \- net.minidev:accessors-smart:jar:2.5.0:test
[INFO]    |     \- org.ow2.asm:asm:jar:9.3:test
[INFO]    +- org.assertj:assertj-core:jar:3.24.2:test
[INFO]    |  \- net.bytebuddy:byte-buddy:jar:1.14.12:test
[INFO]    +- org.awaitility:awaitility:jar:4.2.0:test
[INFO]    +- org.hamcrest:hamcrest:jar:2.2:test
[INFO]    +- org.junit.jupiter:junit-jupiter:jar:5.10.2:test
[INFO]    |  +- org.junit.jupiter:junit-jupiter-api:jar:5.10.2:test
[INFO]    |  |  +- org.opentest4j:opentest4j:jar:1.3.0:test
[INFO]    |  |  +- org.junit.platform:junit-platform-commons:jar:1.10.2:test
[INFO]    |  |  \- org.apiguardian:apiguardian-api:jar:1.1.2:test
[INFO]    |  +- org.junit.jupiter:junit-jupiter-params:jar:5.10.2:test
[INFO]    |  \- org.junit.jupiter:junit-jupiter-engine:jar:5.10.2:test
[INFO]    |     \- org.junit.platform:junit-platform-engine:jar:1.10.2:test
[INFO]    +- org.mockito:mockito-core:jar:5.7.0:test
[INFO]    |  +- net.bytebuddy:byte-buddy-agent:jar:1.14.12:test
[INFO]    |  \- org.objenesis:objenesis:jar:3.3:test
[INFO]    +- org.mockito:mockito-junit-jupiter:jar:5.7.0:test
[INFO]    +- org.skyscreamer:jsonassert:jar:1.5.1:test
[INFO]    |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO]    +- org.springframework:spring-core:jar:6.1.4:compile
[INFO]    |  \- org.springframework:spring-jcl:jar:6.1.4:compile
[INFO]    +- org.springframework:spring-test:jar:6.1.4:test
[INFO]    \- org.xmlunit:xmlunit-core:jar:2.9.1:test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.967 s
[INFO] Finished at: 2024-03-21T09:53:36+08:00
[INFO] ------------------------------------------------------------------------
```
## Spring Boot Web Application ##

The @RestController annotation is the controller to handle income HTTP web requests, equivalent to @Controller and @ResponseBody. The @RequestMapping("/") annotation is for routing; it mapped the HTTP web requests with a / path to the Hello() method. HelloController.java file as below.
```java
package com.dc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * 
 * @Controller + @ResponseBody = @RestController
 */
// @Controller
// @ResponseBody
@RestController
public class HelloController {

  @RequestMapping("/")
  public String Hello() {
    return "Hello World, Spring Boot!";
  }
}
```

## Add unit test ##
Below are the two example of writing unit tests for the spring boot web application.
### MockMvc ###
We can use MockMvc to perform the test on the path /. The MockMvc mocks all MVC components; it's fast because there is no need to start an entire HTTP server. As below is 

