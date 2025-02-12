package com.rama.app.concept;

public class Student {
    String name;
    int age;
    String roll;

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

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void studentDetail(){
        System.out.println("Student Details Name:"+name +" Age"+age+" Roll"+roll);
    }
}
