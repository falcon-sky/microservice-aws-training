## Build Application

    mvn clean install

## Start localstack docker 

    docker-compose -f docker-compose-localstack.yml up

## Running Local Profile

    mvn spring-boot:run -Dspring-boot.run.profiles=local

## Start Parking

    curl --location 'http://localhost:8081/start/parking' \
    --header 'sessionid: sessionid-1' \
    --header 'Content-Type: application/json' \
    --data '{
    "carRegNo": "car1",
    "parkingNo":"park1",
    "parkingStatus":"start"
    }
    '

## End Parking

    curl --location --request POST 'http://localhost:8081/end/parking?carRegNo=car1'

## Dockerization

    docker build -t parking-app .

## List docker images

    docker images

## Start and run both container same time
