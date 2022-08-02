# SpringPosts

  Contains microservice for CRUD operation on Posts table.
  ## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [MySQL 5.7](https://dev.mysql.com/downloads/mysql/5.7.html)

## Running the application locally

First Make sure your mysql is running fine in local if you want to run the application locally. You can change mysql `username` and `password` from `application.properties` within the resources package.

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn clean install
mvn spring-boot:run
```

## API Documentation

You can check swagger documentation at: `http://<HOST_URL>/swagger-ui.html`

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
