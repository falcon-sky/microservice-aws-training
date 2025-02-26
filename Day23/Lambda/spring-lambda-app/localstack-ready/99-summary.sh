#!/usr/bin/env bash
set -euo pipefail
LOCALSTACK_URL=http://localhost:4566
AWS_REGION=eu-west-1
awslocal --endpoint-url=${LOCALSTACK_URL} --region ${AWS_REGION} lambda list-functions
awslocal --endpoint-url=${LOCALSTACK_URL} --region ${AWS_REGION} iam list-roles
curl localstack:4566/_localstack/init | jq -r '.'
