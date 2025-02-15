package com.dynamodb.app.service;

import com.dynamodb.app.exception.ParkingException;
import com.dynamodb.app.module.ParkingStatusTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class DynamoDbServices {
  private static final Logger logger = LogManager.getLogger(DynamoDbServices.class);

  private final DynamoDbClient dynamoDbClient;
  @Value("${amazon.aws.dynamodb.parking.table}")
  private String tableName;

  public DynamoDbServices(DynamoDbClient dynamoDbClient) {
    this.dynamoDbClient = dynamoDbClient;
  }

  public void storeParkingStatus(String regNo, String parkNo, Instant startTime, Instant endTime, String parkingStatus) throws ParkingException {
    Map<String, AttributeValue> item = new HashMap<>();

    // Create the item to store in DynamoDB
    item.put(ParkingStatusTable.FIELD_CAR_REG_NO, AttributeValue.builder().s(regNo).build());
    item.put(ParkingStatusTable.FIELD_PARKING_NO, AttributeValue.builder().s(parkNo).build());
    item.put(ParkingStatusTable.FIELD_START_TIME, AttributeValue.builder().s(startTime.toString()).build());
    item.put(ParkingStatusTable.FIELD_END_TIME, AttributeValue.builder().s(endTime.toString()).build());
    item.put(ParkingStatusTable.FIELD_PARKING_STATUS, AttributeValue.builder().s(parkingStatus).build());

    PutItemRequest putItemRequest = PutItemRequest.builder()
        .tableName(tableName)
        .item(item)
        .build();

    try {
      PutItemResponse putItemResponse = dynamoDbClient.putItem(putItemRequest);
      logger.info("PutItem succeeded: {}", putItemResponse);
    } catch (DynamoDbException e) {
      logger.error("Unable to add item querying table: {} in DynamoDB table ", tableName, e);
      throw new ParkingException("AWS service exception while storing in DynamoDB table: " + e.getMessage());
    }
  }

  public QueryResponse getItemFromDynamoDb(String carRegNo) throws ParkingException {
    logger.info("Retrieve item from Table: {} for Car Registration NUmber:{}", tableName, carRegNo);
    try {
      Map<String, String> expressionAttributeNames = new HashMap<>();
      expressionAttributeNames.put("#carRegNo", ParkingStatusTable.FIELD_CAR_REG_NO);
      expressionAttributeNames.put("#parkNo", ParkingStatusTable.FIELD_PARKING_NO);  // Alias for 'source'
      expressionAttributeNames.put("#startTime", ParkingStatusTable.FIELD_START_TIME);
      expressionAttributeNames.put("#endTime", ParkingStatusTable.FIELD_END_TIME);
      expressionAttributeNames.put("#parkingStat", ParkingStatusTable.FIELD_PARKING_STATUS);
      // Expression Attribute Values
      Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
      expressionAttributeValues.put(":carRegNo", AttributeValue.builder().s(carRegNo).build());
      // Create the QueryRequest
      QueryRequest queryRequest = QueryRequest.builder()
          .tableName(tableName)
          .keyConditionExpression("carRegNo = :carRegNo")
          .projectionExpression("#carRegNo, #parkNo, #startTime,#endTime, #parkingStat")
          .expressionAttributeNames(expressionAttributeNames)
          .expressionAttributeValues(expressionAttributeValues)
          .build();
      return dynamoDbClient.query(queryRequest);
    } catch (DynamoDbException e) {
      logger.error("AWS service exception while querying table: {} in DynamoDB table ", tableName, e);
      throw new ParkingException("AWS service exception while querying in DynamoDB table: " + e.getMessage());
    } catch (Exception e) {
      logger.error("Unexpected ERROR querying table: {} in DynamoDB table: ", tableName, e);
      throw new ParkingException("Unexpected ERROR querying  in DynamoDB table: " + e.getMessage());
    }
  }
}
