package com.rama.app.runnableapp;

import com.rama.app.threadapp.Test1Thread;

public class TestThread {
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName());
    Thread t1 = new Thread(new Test1Thread());
    Thread t2 = new Thread(new Test2Thread());
    Thread t3 =new Thread(new Test3Thread());
    t1.start();
    t2.start();
    t3.start();
  }
}
