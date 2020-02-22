package com.qiming;

public class RunCondition {

  public static void main (String args[]) throws InterruptedException {
    MyService service = new MyService();
    ThreadA a = new ThreadA(service);
    a.start();
    Thread.sleep(3000);
    service.signal();
  }

}
