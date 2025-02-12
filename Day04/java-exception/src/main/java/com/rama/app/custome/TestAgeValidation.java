package com.rama.app.custome;

public class TestAgeValidation {
  public static void main(String[] args) {
    TestAgeValidation test=new TestAgeValidation();
    try{
      test.validateAge(19);
    }catch(AgeValidationException e){
      e.printStackTrace();
      System.out.println(e.getMessage());
    }finally{
      System.out.println("datadase session closed");
    }
  }

  public void validateAge(int age) throws AgeValidationException {
    if (age < 18) {
      throw new AgeValidationException("Age must be 18 or older.");
    }
  }
}
