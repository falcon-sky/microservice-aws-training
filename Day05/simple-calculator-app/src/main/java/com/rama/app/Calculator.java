package com.rama.app;

public class Calculator {
  public double add(double first, double second) {
            return first+second;
  }

  public double subtract(double first, double second) {
    return first-second;
  }
  public double multiply(double first, double second) {
    return first*second;
  }

  public double divide(double first, double second) {
    try {
      return first / second;
    }catch (ArithmeticException e) {
      throw new ArithmeticException("Divide by zero");
    }
  }
}
