#!/usr/bin/env bash
set -euo pipefail
LOCALSTACK_URL=http://localhost:4566
AWS_REGION=eu-west-1

awslocal --endpoint-url=${LOCALSTACK_URL} --region ${AWS_REGION} kinesis list-streams
awslocal --endpoint-url=${LOCALSTACK_URL} --region ${AWS_REGION} dynamodb list-tables
awslocal --endpoint-url=${LOCALSTACK_URL} --region ${AWS_REGION} cloudwatch list-metrics
curl localstack:4566/_localstack/init | jq -r '.'
