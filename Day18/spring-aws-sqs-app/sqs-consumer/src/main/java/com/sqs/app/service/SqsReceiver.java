package com.sqs.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Configuration
public class SqsReceiver {
  private static final Logger logger = LoggerFactory.getLogger(SqsReceiver.class);
  private final SqsAsyncClient sqsClient;
  private final ObjectMapper objectMapper;
  public SqsReceiver(SqsAsyncClient sqsClient, ObjectMapper objectMapper) {
    this.sqsClient = sqsClient;
    this.objectMapper = objectMapper;
  }

  public List<Message> readFromQueue(String queueName) throws ExecutionException, InterruptedException {
    logger.info("Will receive messages from {}", queueName);
    ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
        .queueUrl(queueName)
        .maxNumberOfMessages(1)
        .waitTimeSeconds(20)
        .messageAttributeNames(".*")
        .build();
    ReceiveMessageResponse response = sqsClient.receiveMessage(receiveMessageRequest).get();
    logger.info("Message read response: {}", response);
    return response.messages();
  }

  public <T> Pair<T, Map<String, MessageAttributeValue>> consumeMessage(String queueName, Class<T> messageType) throws ExecutionException, InterruptedException,
      JsonProcessingException {
    List<Message> messages = readFromQueue(queueName);
    if (messages.isEmpty()) {
      return null;
    }
    Message message = messages.get(0);
    deleteFromMessageQueue(queueName, message);
    return Pair.of(objectMapper.readValue(message.body(), messageType), message.messageAttributes());
  }
  public void deleteFromMessageQueue(String queueName, Message message) throws ExecutionException, InterruptedException {
    logger.info("Will delete messages from {}", queueName);
    DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
        .queueUrl(queueName)
        .receiptHandle(message.receiptHandle())
        .build();
    DeleteMessageResponse response = sqsClient.deleteMessage(deleteMessageRequest).get();
    logger.info("Message delete response: {}", response);
  }
}
