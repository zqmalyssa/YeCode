package com.qiming.test;

public class MyThread extends Thread{

  public void run() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("MyThread thread");
  }

}
