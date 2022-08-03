## build jar ##
FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /home/app
COPY pom.xml ./
RUN mvn verify --fail-never
ADD src ./src
RUN mvn package

## run package ##
FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY --from=build /home/app/target/posts-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
