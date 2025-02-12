package com.rama.app.model;

public class Goat extends Animal {

    public void eat(){
        System.out.println("Goat eat grass");
    }

    @Override
    public void sleep() {
        System.out.println("Goat sleep");
    }
}
