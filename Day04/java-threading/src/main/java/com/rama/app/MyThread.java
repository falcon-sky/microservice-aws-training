package com.rama.app;

public class MyThread extends Thread {
  public void run() {
    System.out.println("Thread is running...");
    System.out.println(Thread.currentThread().getName());
  }
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName());
    MyThread thread = new MyThread();
    thread.start();
  }
}
