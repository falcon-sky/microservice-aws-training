package com.rama.app.runnableapp;

public class Test2Thread implements Runnable {
  public void run() {
    System.out.println("Thread2 is running...");
    System.out.println(Thread.currentThread().getName());
  }
}
