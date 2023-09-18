# Treadcrumbs Backend - A Farming Simulator Companion and Analysis web application.
![Dashboard](https://i.imgur.com/2Ljt9oD.png)
## Project Description
This is the backend for my dissertation project. A more detailed writeup about this application and the features it has can be found [here](https://github.com/not-nic/treadcrumbs-frontend/).

This is a Single user application that utilises Spring Boot. This backend provides different RESTful API endpoints to upload an entire save game, request uploaded data from a Postgres database, and manipulate it by adding new Fields, Vehicles, Notes and Finances.

This was the first major project I had created with Spring Boot, which have lead to many areas I would like to revisit and improve upon in the future. 

There are things within this project that remain unpolished and unfinished. However, there are a few choices that are intentional, particularly within [this method]( https://github.com/not-nic/treadcrumbs-backend/blob/main/src/main/java/uk/notnic/fsdashboard/service/ServiceHelper.java), (which used in every service) that throws both a `DocumentException` and  `JAXBException`. This was intentional as part of my report was comparing these two XML parsing techniques.

## How to Use
The API comes with many endpoints so I have provided a postman collection which can be [used / downloaded](https://app.getpostman.com/run-collection/20934928-2d302fdf-5884-4516-8ef5-40f9f1c6c4dd?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D20934928-2d302fdf-5884-4516-8ef5-40f9f1c6c4dd%26entityType%3Dcollection%26workspaceId%3Df4607a5b-e580-4ca1-bcf3-e2688d3b4a16). However, if you prefer not to use this, the API endpoints can be found within each [controller](https://github.com/not-nic/treadcrumbs-backend/tree/main/src/main/java/uk/notnic/fsdashboard/controller) file, many are complete, but a few may be missing requests. 

## Install Guide
1. Clone this repository on your machine using the following command:
```bash
https://github.com/not-nic/treadcrumbs-backend.git
cd treadcrumbs-backend
```
2. View `application.properties` and enter your own postgres database details or use the one provided.
```bash
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password
spring.servlet.multipart.max-file-size=30MB
```
3. Start a PostgreSQL database through your own preferred method, or start one through Docker.
```bash
docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres
```
4. CD to the project directory and start Spring Boot by using:
```nash
mvn spring-boot:run
```
## Build Guide
1. To build the application use the following command:
```bash
mvn clean package
```
2.  Run the application using:
```bash
java -jar target/fs-dashboard-0.0.1-SNAPSHOT.jar
```
