package com.qiming.concurrent;

public class MyThreadB extends Thread {

  private Service service;

  public MyThreadB(Service service) {
    this.service = service;
  }

  @Override
  public void run() {
    service.notifyMethod();
  }
}
