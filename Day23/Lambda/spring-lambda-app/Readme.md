## Build
    mvn clean package

## Test

    curl -X POST http://localhost:8080/function/hello -H "Content-Type: text/plain" -d "Rama"

## Verify menifest

    unzip -p target/spring-lambda-app-1.0.0.jar META-INF/MANIFEST.MF

## check class in jar

    jar tvf target/spring-lambda-app-1.0.0.jar | grep LambdaHandler

## Create lambda function

    aws lambda create-function \
    --function-name springboot-serverless \
    --runtime java21 \
    --role arn:aws:iam::860523622096:role/vccproductconfig-val2-eu-west-1-svss-validator-role \
    --handler com.example.app.LambdaHandler::handleRequest \
    --zip-file fileb://target/spring-lambda-app-1.0.0.jar \
    --memory-size 512 \
    --timeout 15 \
    --profile eu-val2-pc


## Deploy from target folder

    aws lambda update-function-code \
    --function-name springboot-serverless \
    --zip-file fileb://target/spring-lambda-app-1.0.0.jar \
    --profile eu-val2-pc 


## Test

    aws  lambda invoke --function-name springboot-serverless \
    --payload fileb://event.json \
    --profile eu-val2-pc \
    --cli-binary-format raw-in-base64-out \
    /dev/stdout | jq


## Remove lambda function

    aws lambda delete-function --function-name springboot-serverless --profile eu-val2-pc 


## Update handler

    aws lambda update-function-configuration --function-name springboot-serverless --handler com.example.app.LambdaHandler::handleRequest --profile eu-val2-pc 

## Deploy Using cloudformation

    
