package com.sqs.app.service;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SqsSender {
  private static final Logger logger = LoggerFactory.getLogger(SqsSender.class);

  private final SqsTemplate queueMessagingTemplate;
  @Value("${amazon.aws.sqs.queue.incoming}")
  private String inQueueName;

  public SqsSender(SqsTemplate queueMessagingTemplate) {
    this.queueMessagingTemplate = queueMessagingTemplate;
  }

  public void sendMessage(String message, Map<String, Object> headers) {
    logger.info("sending on queue: {} message: {} headers: {}", inQueueName, message, headers);
    this.queueMessagingTemplate.send(inQueueName,
        MessageBuilder.withPayload(message)
            .copyHeaders(headers)
            .build());
  }
}
