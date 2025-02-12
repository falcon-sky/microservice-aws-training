package com.sqs.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sqs.app.module.Student;
import com.sqs.app.service.SqsReceiver;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import org.springframework.http.HttpHeaders;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class ReceiveController {
  private final SqsReceiver sqsReceiver;
  @Value("${amazon.aws.sqs.queue.incoming}")
  private String inQueueName;

  public ReceiveController(SqsReceiver sqsReceiver) {
    this.sqsReceiver = sqsReceiver;
  }

  @GetMapping("/receive")
  public ResponseEntity<Student> receive() throws ExecutionException, InterruptedException, JsonProcessingException {
    Pair<Student, Map<String, MessageAttributeValue>> message = sqsReceiver.consumeMessage(inQueueName, Student.class);
    Student result = message.getLeft();
    Map<String, MessageAttributeValue> messageHader  = message.getValue();
    HttpHeaders headers = new HttpHeaders();
    messageHader.forEach((key, value) -> {
      if (value.stringValue() != null) {
        headers.add("X-" + key, value.stringValue()); // Prefix with "X-" to follow header naming convention
      }
    });
    return new ResponseEntity<>(result, headers, HttpStatus.OK);
  }
}
