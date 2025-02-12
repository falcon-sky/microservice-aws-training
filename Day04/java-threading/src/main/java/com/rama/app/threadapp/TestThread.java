package com.rama.app.threadapp;

public class TestThread {
  private int count = 0;
  public synchronized void increment() {
    count ++;
  }
  public synchronized void print(String name) {
    System.out.println("Name:"+name+":"+count);
  }
  public static void main(String[] args) throws InterruptedException {
    System.out.println(Thread.currentThread().getName());
    Test1Thread t1 = new Test1Thread();
    Test2Thread t2 = new Test2Thread();
    Test3Thread t3 = new Test3Thread();
    t1.start();
    t2.start();
    t3.start();
    try {
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
