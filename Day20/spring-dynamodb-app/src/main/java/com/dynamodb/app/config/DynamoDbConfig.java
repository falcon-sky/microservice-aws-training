package com.dynamodb.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


@Configuration
@Profile("!local")
public class DynamoDbConfig {

  @Bean
  @Primary
  public DynamoDbClient dynamoDbClient(@Value("${SITE:eu-west-1}") String region) {
    return DynamoDbClient
        .builder()
        .region(Region.of(region))
        .build();
  }
}
