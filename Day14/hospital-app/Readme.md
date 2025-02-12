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
$ docker build -t hospital-app .
```
## List docker images
```
$ docker images
```

### Running the application in docker container

```
$ docker run -p 8080:8080 hospital-app:latest
```

## List docker running container

```
$ docker ps
```

