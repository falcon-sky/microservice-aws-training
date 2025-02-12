package com.rama.app.threadapp;

public class Test3Thread  extends Thread {
  public void run() {
//    System.out.println("Thread3 is running...");
//    System.out.println(Thread.currentThread().getName());
    TestThread t1 = new TestThread();
    t1.increment();
    t1.print(Thread.currentThread().getName());
  }
}
