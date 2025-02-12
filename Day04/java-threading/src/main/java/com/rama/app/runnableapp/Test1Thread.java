package com.rama.app.runnableapp;

public class Test1Thread  implements Runnable {
  public void run() {
    System.out.println("Thread1 is running...");
    System.out.println(Thread.currentThread().getName());
  }
}
