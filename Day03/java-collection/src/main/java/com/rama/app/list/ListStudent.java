package com.rama.app.list;

import com.rama.app.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListStudent {
  public static void main(String[] args) {
    List<Student> studentList=new ArrayList<>();
    Student student1= new Student("st1",20,"roll1");
    Student student2= new Student("st2",21,"roll2");
    Student student3= new Student("st3",22,"roll3");
    Student student4= new Student("st4",23,"roll4");
    Student student5= new Student("st5",24,"roll5");
    Student student6= new Student("st6",25,"roll6");
    Student student7= new Student("st7",26,"roll7");
    studentList.add(student1);
    studentList.add(student2);
    studentList.add(student3);
    studentList.add(student4);
    studentList.add(student5);
    studentList.add(student6);
    studentList.add(student7);
    for (Student student : studentList) {
      student.print();
    }
    System.out.println("Student Greater than 23");
    List<Student> student23PlusAge=studentList.stream()
        .filter(student -> student.getAge()>23)
        .collect(Collectors.toList());
    for (Student student : student23PlusAge) {
      student.print();
    }
  }

}
