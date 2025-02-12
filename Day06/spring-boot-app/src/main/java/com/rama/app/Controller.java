package com.rama.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class Controller {
  @GetMapping("/hello")
  public String sayHello() {
    return "Hello, This is my application!";
  }
  @GetMapping("/hi")
  public String sayHi() {
    return "Hi, This is my application!";
  }

  @PostMapping ("/send")
  public String sendData() {
    return "Sending data";
  }
}
