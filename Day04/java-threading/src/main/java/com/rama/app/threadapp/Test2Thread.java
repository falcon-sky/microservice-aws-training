package com.rama.app.threadapp;

public class Test2Thread  extends Thread {
  public void run() {
//    System.out.println("Thread2 is running...");
//    System.out.println(Thread.currentThread().getName());
    TestThread t1 = new TestThread();
    t1.increment();
    t1.print(Thread.currentThread().getName());
  }
}
