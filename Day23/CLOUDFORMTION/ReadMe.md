# Cloud Formation Commands

## Create a Stack

    aws cloudformation create-stack --stack-name MyStack --template-body file://my-template.json --parameters ParameterKey=InstanceType,ParameterValue=t2.micro

    
## Update Stack

    aws cloudformation update-stack --stack-name MyStack --template-body file://updated-template.json --parameters ParameterKey=InstanceType,ParameterValue=t3.micro

## Delete a Stack

    aws cloudformation delete-stack --stack-name MyStack

## Describe a Stack

    aws cloudformation describe-stacks --stack-name MyStack

##  List All Stacks

    aws cloudformation list-stacks

    
## Validate a Template

    aws cloudformation validate-template --template-body file://my-template.json

## Preview Changes with Change Sets

### Create a change set
    
    aws cloudformation create-change-set --stack-name MyStack --template-body file://updated-template.json --change-set-name MyChangeSet

### View the change set
    
    aws cloudformation describe-change-set --change-set-name MyChangeSet --stack-name MyStack

### Execute the change set

    aws cloudformation execute-change-set --change-set-name MyChangeSet --stack-name MyStack

## Export Stack Outputs

    aws cloudformation describe-stacks --stack-name MyStack --query "Stacks[0].Outputs"


    
