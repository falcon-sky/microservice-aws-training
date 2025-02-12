package com.rama.app;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();
    double result=calculator.add(3,4);
    assert result==7;
  }
  @Test
  public void testSubtract() {
    Calculator calculator = new Calculator();
    double result = calculator.subtract(9,5);
    assert result==4;
  }
  @Test
  public void testMultiply() {
    Calculator calculator = new Calculator();
    double result= calculator.multiply(5,6);
    assert result==30;
  }

  @Test
  public void testDivision() {
    Calculator calculator = new Calculator();
      double result = calculator.divide(15, 0);
      assert result==7.5;
  }

  @Test
  public void testException() {
    Calculator calculator = new Calculator();
    try {
      double result = calculator.divide(5, 0);
    } catch (ArithmeticException e) {
      assert e.getMessage().contains("Divide zero");
    }
  }

  @Test(expected = ArithmeticException.class)
  public void testException2() {
    int result= 3/0;
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testIndexException() {
    List<Integer> list= Arrays.asList(1,2,3,4,5);
    list.get(8);
  }

  @Test
  public void testIndexAssertException() {
    List<Integer> list= Arrays.asList(1,2,3,4,5);
    try {
      list.get(8);
    }catch (IndexOutOfBoundsException e) {
      assert e.getMessage().contains("Index 8 out of bounds for length 5");
    }
  }


}
