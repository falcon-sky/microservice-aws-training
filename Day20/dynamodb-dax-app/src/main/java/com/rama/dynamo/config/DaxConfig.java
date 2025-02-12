package com.rama.dynamo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.dax.ClusterDaxAsyncClient;
import software.amazon.dax.Configuration;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class DaxConfig {
  private static final String DAX_ENDPOINT = "dax-cluster.endpoint:8111"; // Replace with your DAX endpoint
  @Value("${DAX_ENDPOINT:endpoint}")
  private String daxEndpoint;

  @Bean
  @Profile("dax")
  public DynamoDbAsyncClient daxClient(@Value("${SITE:eu-west-1}") String region)
      throws IOException {
    return ClusterDaxAsyncClient.builder()
        .overrideConfiguration(Configuration.builder()
            .url(daxEndpoint)
            .build())
        .build();
  }

  @Bean
  @Primary
  public DynamoDbClient dynamoDbClient(@Value("${SITE:eu-west-1}") String region) {
    return DynamoDbClient
        .builder()
        .region(Region.of(region))
        .build();
  }

}
