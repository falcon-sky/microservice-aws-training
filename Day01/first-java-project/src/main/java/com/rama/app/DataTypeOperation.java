package com.rama.app;

public class DataTypeOperation {
   String name= "Test";
   char a='A';
  public void narrowingOperation() {
    double c= 20.0;
    int d= (int)c;
    System.out.println( "c:"+c );
    System.out.println( "d:"+d );
  }
  public void wideningOperation() {
    int a=10;
    double b=a;
    System.out.println( "a:"+a );
    System.out.println( "b:"+b );
  }

  public void dataTypeSize() {
    System.out.println("Size of byte: " + Byte.BYTES + " bytes");
    System.out.println("Size of short: " + Short.BYTES + " bytes");
    System.out.println("Size of int: " + Integer.BYTES + " bytes");
    System.out.println("Size of long: " + Long.BYTES + " bytes");
    System.out.println("Size of float: " + Float.BYTES + " bytes");
    System.out.println("Size of double: " + Double.BYTES + " bytes");
    System.out.println("Size of char: " + Character.BYTES + " bytes");
  }
}
