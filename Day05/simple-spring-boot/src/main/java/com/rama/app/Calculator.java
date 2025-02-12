package com.rama.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
  private final CalculateArea calculateArea;

  public Calculator(CalculateArea calculateArea) {
    this.calculateArea = calculateArea;
  }

    public int add(int a, int b) {
      return a + b;
    }
    public int subtract(int a, int b) {
      return a - b;
    }
    public int multiply(int a, int b) {
      return a * b;
    }
    public int divide(int a, int b) {
      return a / b;
    }
    public float areaCalculateCircle(float a) {
      return calculateArea.circleArea(a);
    }
    public float areaCalculateSquare(float a) {
    return calculateArea.squareArea(a);
    }

}
