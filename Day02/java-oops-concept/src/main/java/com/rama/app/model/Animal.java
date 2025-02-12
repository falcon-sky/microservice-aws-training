package com.rama.app.model;

public class Animal {
    public void eat() {
        System.out.println("This animal eats food.");
        secretMethod();
    }

    public void sleep() {
        System.out.println("This animal sleeps.");
    }

    private void secretMethod() {
        System.out.println("This animal secrets.");
    }
}
