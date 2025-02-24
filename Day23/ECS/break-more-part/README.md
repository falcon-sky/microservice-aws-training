# Create ECS infrastructure

## Create VPC Network Infrastructure

    aws cloudformation deploy \
        --template-file 1-vpc-networking.yml \
        --stack-name create-vpc-network-infra \
        --capabilities CAPABILITY_NAMED_IAM \
        --profile rama

## Create load balancer infra

    aws cloudformation deploy \
        --template-file 2-load-balancer.yml \
        --stack-name create-load-balancer-infra \
        --capabilities CAPABILITY_NAMED_IAM \
        --profile rama

## Create Security Group infra

    aws cloudformation deploy \
        --template-file 3-security-groups.yml \
        --stack-name create-security-group-infra \
        --capabilities CAPABILITY_NAMED_IAM \
        --profile rama

## Create ECS Cluster infra

    aws cloudformation deploy \
        --template-file 4-ecs-cluster.yml \
        --stack-name create-ecs-cluster-infra \
        --capabilities CAPABILITY_NAMED_IAM \
        --profile rama

## Create ECS Service and Task infra

    aws cloudformation deploy \
        --template-file 5-ecs-service-task.yml \
        --stack-name create-ecs-service-task-infra \
        --capabilities CAPABILITY_NAMED_IAM \
        --profile rama

### Invoke calculator api using ALB

    curl  "<ALB-DNS-Name>/actuator/health/"

    curl  "http://MicroserviceALB-825081192.us-east-1.elb.amazonaws.com/actuator/health/"

### Test application using load balancer
    http://MicroserviceALB-825081192.us-east-1.elb.amazonaws.com/swagger-ui/index.html#
    curl -X GET "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/addition?a=9&b=5"
    curl -X GET "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/substraction?a=9&b=5"
    curl -X POST "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/multiplication?a=9&b=5"
    curl -X PUT "http://CalculatorALB-749001651.us-east-1.elb.amazonaws.com/division?a=9&b=5"

## Create ECS Service and Task infra

    aws cloudformation delete-stack \
        --stack-name create-ecs-service-task-infra \
        --profile rama

## Delete pre ECS cluster Stack

    aws cloudformation delete-stack \
        --stack-name create-ecs-cluster-infra \
        --profile rama
