package com.rama.app.threadapp;

public class Test1Thread  extends Thread {
  public void run() {
//    System.out.println("Thread1 is running...");
//    System.out.println(Thread.currentThread().getName());
    TestThread t1 = new TestThread();
    t1.increment();
    t1.print(Thread.currentThread().getName());
  }
}
