### Build

    mvn clean package

### Verify Spring Bot starts

    mvn spring-boot:run

### Create Local Stack Infrastructure and Run Lambda

    docker-compose up

### Verify Localstack UI if its deployed
    
    https://app.localstack.cloud/inst/default/status
    
### Test Lambda with CLI

    awslocal --endpoint-url=http://localhost:4566 lambda invoke \
    --function-name springboot-serverless \
    --payload fileb://event.json \
    --cli-binary-format raw-in-base64-out \
    /dev/stdout | jq


    
