package com.sqs.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqs.app.module.Student;
import com.sqs.app.service.SqsSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MessageController {
  private final SqsSender sqsSender;
  private final ObjectMapper objectMapper;

  public MessageController(SqsSender sqsSender, ObjectMapper objectMapper) {
    this.sqsSender = sqsSender;
    this.objectMapper = objectMapper;
  }

  @PostMapping("/send")
  public String sendMessage(@RequestBody Student student, @RequestHeader("sessionid") String sessionid) throws JsonProcessingException {
    Map<String, Object> headers = new HashMap<>();
    String ambCorrelationId = UUID.randomUUID().toString();
    headers.put("AMB_CORRELATION_ID", ambCorrelationId);
    headers.put("SESSION_ID", sessionid);
    String jsonString = objectMapper.writeValueAsString(student);
    sqsSender.sendMessage(jsonString, headers);
    return ambCorrelationId;
  }
}
