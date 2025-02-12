package com.rama.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/caller")
public class CallerController {
  private static final Logger LOGGER = LoggerFactory.getLogger(CallerController.class);

  private final RestTemplate restTemplate;

  public CallerController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
  @Value("${get.receive.url}")
  String receivegetUrl; //http://localhost:10082/receiver/get

  @Value("${post.receive.url}")
  String receivepostUrl; //http://localhost:10082/receiver/post

  @Value("${put.receive.url}")
  String receiveputUrl; //http://localhost:10082/receiver/put

  @Value("${delete.receive.url}")
  String receivedeleteUrl; //http://localhost:10082/receiver/delete


  @GetMapping("/get")
  public String getDetail() {

    ResponseEntity<String> response
      = restTemplate.exchange(receivegetUrl,HttpMethod.GET, null,String.class);
    LOGGER.info(response.getStatusCode().toString());
    LOGGER.info(response.getBody());
    return response.getBody();
  }

  @PostMapping("/post")
  public String postDetail() {
    ResponseEntity<String> response
            = restTemplate.exchange(receivepostUrl, HttpMethod.POST,null, String.class);
    LOGGER.info(response.getStatusCode().toString());
    LOGGER.info(response.getBody());
    return response.getBody();
  }

  @PutMapping ("/put")
  public String putDetail() {
    ResponseEntity<String> response
            = restTemplate.exchange(receiveputUrl, HttpMethod.PUT,null, String.class);
    LOGGER.info(response.getStatusCode().toString());
    LOGGER.info(response.getBody());
    return response.getBody();
  }

  @DeleteMapping("/delete")
  public String deletetDetail() {
    ResponseEntity<String> response
            = restTemplate.exchange(receivedeleteUrl, HttpMethod.DELETE,null, String.class);
    LOGGER.info(response.getStatusCode().toString());
    LOGGER.info(response.getBody());
    return response.getBody();
  }
}
