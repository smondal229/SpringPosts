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

## Deployment with minikube

1. Start minikube first:
```
minikube start
```

2. Create Namespace, Secrets and configmap:
```
kubectl apply -f app-namespace.yml
kubectl apply -f app-secret.yml
kubectl apply -f app-deployment.yml
```
3. Copy secrets and configmap to required workspace:

```
kubectl get secret app-secret --namespace=posts-api  -o yaml \
  | sed 's/namespace: posts-api/namespace: default/' \
  | kubectl create -f -

kubectl get configmap posts-configmap --namespace=posts-api  -o yaml \
  | sed 's/namespace: posts-api/namespace: default/' \
  | kubectl create -f -
```
4. Create Database and app deployments:

```
kubectl apply -f mysql-deployment.yml
```
You can check if the mysql pod running by: ```kubectl get pods --watch```

Then run the application deployment:
```
kubectl apply -f app-deployment.yml
```
You can check if the mysql pod running by: ```kubectl get pods -n posts-api --watch```

5. Once all pods are running successfully check ```minikube ip``` in your system. Then run the web application in the browser with `http://<minikube-ip>/swagger-ui.html`
## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
