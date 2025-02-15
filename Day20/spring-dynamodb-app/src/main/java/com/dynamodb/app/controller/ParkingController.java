package com.dynamodb.app.controller;

import com.dynamodb.app.exception.ParkingException;
import com.dynamodb.app.module.Parking;
import com.dynamodb.app.module.ParkingResponse;
import com.dynamodb.app.module.ParkingStatusTable;
import com.dynamodb.app.service.DynamoDbServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ParkingController {
  private static final Logger logger = LogManager.getLogger(ParkingController.class);
  private final DynamoDbServices dynamoDbServices;

  public ParkingController(DynamoDbServices dynamoDbServices) {
    this.dynamoDbServices = dynamoDbServices;
  }

  @PostMapping("/start/parking")
  public void startParking(@RequestBody Parking parking) throws ParkingException {
    Instant startTime = Instant.now();
    Instant endTime = startTime.plusSeconds(3600);
    dynamoDbServices.storeParkingStatus(parking.getCarRegNo(), parking.getParkingNo(), startTime, endTime, parking.getParkingStatus());
  }

  @PostMapping("/end/parking")
  public List<ParkingResponse> endParking(@RequestParam("carRegNo") String carRegNo) throws ParkingException {
    QueryResponse queryResponse = dynamoDbServices.getItemFromDynamoDb(carRegNo);
    return convertQueryResponseToParkingResponse(queryResponse);
  }

  private List<ParkingResponse> convertQueryResponseToParkingResponse(QueryResponse queryResponse) {
    List<ParkingResponse> parkingResponses = new ArrayList<>();
    for (Map<String, AttributeValue> item : queryResponse.items()) {
      ParkingResponse provisionStateEntry = ParkingResponse.builder()
          .carRegNo(item.get(ParkingStatusTable.FIELD_CAR_REG_NO).s())
          .parkingNo(item.get(ParkingStatusTable.FIELD_PARKING_NO).s())
          .startTime(toDate(item.get(ParkingStatusTable.FIELD_START_TIME)))
          .endTime(toDate(item.get(ParkingStatusTable.FIELD_END_TIME)))
          .parkingStatus(item.get(ParkingStatusTable.FIELD_PARKING_STATUS).s())
          .build();
      parkingResponses.add(provisionStateEntry);
    }

    return parkingResponses;
  }

  private Date toDate(AttributeValue attributeValue) {
    if (attributeValue == null || attributeValue.s() == null) {
      return null;
    } else {
      try {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);
        Instant instant = Instant.from(formatter.parse(attributeValue.s()));
        return Date.from(instant);
      } catch (Exception e) {
        logger.warn("Unable to parse date value '{}', continue without timestamp", attributeValue.s());
        return null;
      }
    }
  }
}
