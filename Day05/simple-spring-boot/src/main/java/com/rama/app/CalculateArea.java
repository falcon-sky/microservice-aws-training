package com.rama.app;

import org.springframework.stereotype.Component;

@Component
public class CalculateArea {
  public float circleArea(float radius) {
    return  3.14f * radius * radius;
  }
  public float squareArea(float side) {
    return side * side;
  }
}
