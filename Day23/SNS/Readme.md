# SNS Command
## List SNS Topics:
    aws sns list-topics

## Create an SNS Topic:
    aws sns create-topic --name MyTopic

## Subscribe to an SNS Topic:
    aws sns subscribe --topic-arn arn:aws:sns:us-east-1:123456789012:MyTopic --protocol email --notification-endpoint "example@example.com"

## Publish a Message to an SNS Topic:
    aws sns publish --topic-arn arn:aws:sns:us-east-1:123456789012:MyTopic --message "Hello, this is a test message!"

## Unsubscribe from an SNS Topic:
    aws sns unsubscribe --subscription-arn arn:aws:sns:us-east-1:123456789012:MyTopic:abcd1234-abcd-1234-abcd-1234abcd1234

## Delete an SNS Topic:
    aws sns delete-topic --topic-arn arn:aws:sns:us-east-1:123456789012:MyTopic
