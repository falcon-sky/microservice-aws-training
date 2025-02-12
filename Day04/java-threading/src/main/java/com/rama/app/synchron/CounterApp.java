package com.rama.app.synchron;

public class CounterApp {
  public static void main(String[] args) {
    Counter counter = new Counter();
    CounterThread counterThread1 = new CounterThread(counter);
    CounterThread counterThread2 = new CounterThread(counter);
    CounterThread counterThread3 = new CounterThread(counter);
     counterThread1.start();
     counterThread2.start();
     counterThread3.start();
     try{
       counterThread1.join();
       counterThread2.join();
       counterThread3.join();
     } catch (InterruptedException e) {
       throw new RuntimeException(e);
     }

     System.out.println("Final Count:"+counter.getCount());
  }
}
