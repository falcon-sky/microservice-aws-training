#!/usr/bin/env bash
set -euo pipefail
#enable debug:
#set -x
echo "configuring IAM Role "
echo "==================="
LOCALSTACK_URL=http://localhost:4566
AWS_REGION=eu-west-1

create_iam_role(){
  local ROLE_NAME_TO_CREATE=$1
   awslocal --endpoint-url=${LOCALSTACK_URL} iam create-role \
      --role-name ${ROLE_NAME_TO_CREATE} \
      --assume-role-policy-document file://<(echo '{"Version": "2012-10-17","Statement": [{"Effect": "Allow","Principal": {"Service": "lambda.amazonaws.com"},"Action": "sts:AssumeRole"}]}') \
      --region ${AWS_REGION}
  }

list_iam_roles(){
  awslocal --endpoint-url=${LOCALSTACK_URL} iam list-roles
}

create_iam_role LambdaExecutionRole

echo $(list_iam_roles)
