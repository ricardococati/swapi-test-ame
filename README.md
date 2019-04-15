### Rest Api for Star Wars

#### Summary
This project aims at the creation of planets for star wars api.

#### Business rules:
* Add a planet
* List planets from data base
* List planets from Star Wars API
* Find by name from data base
* Find by id from data base
* Remove planet

#### Technology

* [Java 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* [Spring Boot](https://projects.spring.io/spring-boot/)
* [MongoDB](https://www.mongodb.com/) * MongoDB in memory, used to store data
* [JUnit](https://junit.org/junit5/)
* [Swagger](https://swagger.io/)
* [Lombok](https://projectlombok.org/)
* [Maven](https://maven.apache.org/)

#### Architecture
This project uses as a basis the architecture model Clean Architecture
More info: http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

#### Prerequisites for local execution:
Have Java installed on the local machine;

Have maven installed, starting with version 3.3;

#### Steps for project execution

On the root folder of the project run the command:
```
mvn clean install
```
After performing the application build run the application with the following command:

```
mvn spring-boot:run
```

#### Execution port
Execution port default 8666

#### URL Swagger
Connection URL:

* [Swagger URL](http://localhost:8666/swagger-ui.html)
