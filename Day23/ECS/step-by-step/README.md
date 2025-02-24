# Create ECS infrastructure

## Create ECS Pre Requisit Infrastructure

    aws cloudformation deploy \
        --template-file ecs-pre-infrastructure.yml \
        --stack-name create-ecs-pre-infra \
        --capabilities CAPABILITY_NAMED_IAM \
        --profile rama

## Create ECS Infrastructure

    aws cloudformation deploy \
        --template-file ecs-cluster-creation.yml \
        --stack-name create-ecs-infra \
        --capabilities CAPABILITY_NAMED_IAM \
        --profile rama

### Invoke calculator api using ALB

    curl  "<ALB-DNS-Name>/actuator/health/"

    curl  "http://CalculatorALB-1563364189.us-east-1.elb.amazonaws.com/actuator/health/"

### Test application using load balancer
    http://CalculatorALB-1563364189.us-east-1.elb.amazonaws.com/swagger-ui/index.html#
    curl -X GET "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/addition?a=9&b=5"
    curl -X GET "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/substraction?a=9&b=5"
    curl -X POST "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/multiplication?a=9&b=5"
    curl -X PUT "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/division?a=9&b=5"

## Delete  ECS Stack

    aws cloudformation delete-stack \
        --stack-name create-ecs-infra \
        --profile rama


## Delete pre ECS Stack

    aws cloudformation delete-stack \
        --stack-name create-ecs-pre-infra \
        --profile rama
