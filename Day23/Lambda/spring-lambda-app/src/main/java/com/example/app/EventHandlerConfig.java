package com.example.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class EventHandlerConfig {
  private static final Logger logger = LoggerFactory.getLogger(LambdaHandler.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Bean
  public Function<String, String> helloFunction() {
    return event -> {
      logger.info("Received Lambda Event: {}", event);
      return "Lambda Response: " + event;
    };
  }
}
