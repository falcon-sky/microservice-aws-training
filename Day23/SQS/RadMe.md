# SQS aws cli commands
## List all queue
    aws sqs list-queues
## Create new queue
    aws sqs create-queue --queue-name RamaQueue
## Send a Message to an SQS Queue
    aws sqs send-message --queue-url https://sqs.us-east-1.amazonaws.com/123456789012/RamaQueue --message-body "Hello, Rama!"
## Receive Messages from an SQS Queue:
    aws sqs receive-message --queue-url https://sqs.us-east-1.amazonaws.com/123456789012/MyQueue --max-number-of-messages 1
## Delete a Message from an SQS Queue:
    aws sqs delete-message --queue-url https://sqs.us-east-1.amazonaws.com/123456789012/MyQueue --receipt-handle <ReceiptHandle>
## Delete an SQS Queue
    aws sqs delete-queue --queue-url https://sqs.us-east-1.amazonaws.com/123456789012/MyQueue
