package com.rama.rest.reciever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receiver")
public class ReceiverController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverController.class);

  @GetMapping("/get")
  public String getDetail() throws InterruptedException {
    LOGGER.info("Receiver get request:");
    return "Receiver get reponse";
  }

  @PostMapping ("/post")
  public String saveDetail() throws InterruptedException {
    LOGGER.info("Receiver save request:");

    return "Receiver post reponse";
  }

  @PutMapping ("/put")
  public String updatetDetail() throws InterruptedException {
    LOGGER.info("Receiver update request:");

    return "Receiver put reponse";
  }

  @DeleteMapping("/delete")
  public String deleteDetail() throws InterruptedException {
    LOGGER.info("Receiver delete request:");

    return "Receiver delete reponse";
  }
}
