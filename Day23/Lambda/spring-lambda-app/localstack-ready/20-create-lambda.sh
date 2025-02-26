#!/usr/bin/env bash
set -euo pipefail
#enable debug:
#set -x
echo "configuring lambdas "
echo "==================="
LOCALSTACK_URL=http://localhost:4566
AWS_REGION=eu-west-1

mkdir -p tmp

create_lambda() {
    local FUNCTION_NAME=$1
    local HANDLER=$2

    awslocal --endpoint-url=${LOCALSTACK_URL} lambda create-function \
      --function-name ${FUNCTION_NAME} \
      --runtime java21 \
      --region ${AWS_REGION} \
      --handler ${HANDLER} \
      --zip-file fileb:///workdir/spring-lambda-app-1.0.0.jar \
      --role arn:aws:iam::000000000000:role/LambdaExecutionRole
}

list_lambdas() {
    awslocal --endpoint-url=${LOCALSTACK_URL} lambda list-functions
}

#create_lambda springboot-serverless com.example.app.LambdaHandler::handleRequest
create_lambda springboot-serverless org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest
echo $(list_lambdas)
