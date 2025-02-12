package com.rama.app;

public class Student {
  String name;
  int age;
  String rollNo;
  public Student(String name, int age, String rollNo) {
    this.name = name;
    this.age = age;
    this.rollNo = rollNo;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getRollNo() {
    return rollNo;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public void print() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Roll No: " + rollNo);
  }

}
