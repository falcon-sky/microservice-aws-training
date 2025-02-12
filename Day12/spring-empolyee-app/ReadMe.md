# Application for Employee Information

## Build application with maven

```Bash
mvn clean install
```

## Run Application with maven

```Bash
mvn spring-boot:run
```

## Verify End Point Controller

### Verify application Health

```Bash
curl --location 'http://localhost:8080/actuator/health'
```

### Create Employee

```Bash
curl --location 'http://localhost:8080/employee/create/employee' \
--header 'Content-Type: application/json' \
--data '{
     "id":"1",
     "name": "emp1",
     "age":25
}'
```

### Read All Employee Data

```Bash
curl --location 'http://localhost:8080/employee/get/all/employee'
```

### Update Employee Data

```Bash
curl --location --request PUT 'http://localhost:8080/employee/update/employee?id=1&age=22'
```

### Delete Employee Data

```Bash
curl --location --request DELETE 'http://localhost:8080/employee/delete/employee?id=2'
```
## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

### Maven
This project is maven project which will be build using maven command.

```
$ mvn clean install
```

## Dockerization

```
$ mvn install dockerfile:build
```
## List docker images
```
$ docker images
```

### Running the application in docker container

```
$ docker run -p 8080:8080 spring-empolyee-app:1.0.0
```

## List docker running container

```
$ docker ps
```
