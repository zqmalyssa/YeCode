package com.qiming.concurrent;

public class MyThreadA extends Thread {

  private Service service;

  public MyThreadA(Service service) {
    this.service = service;
  }

  @Override
  public void run() {
    service.waitMethod();
  }
}
