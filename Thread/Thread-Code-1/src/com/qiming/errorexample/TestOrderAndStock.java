package com.qiming.errorexample;

public class TestOrderAndStock {

  public static void main(String[] args) {
    Thread thread1 = new Thread(new UserThread(), "User1");
    Thread thread2 = new Thread(new UserThread(), "User2");
    Thread thread3 = new Thread(new UserThread(), "User3");
    Thread thread4 = new Thread(new UserThread(), "User4");
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

  }

  static class UserThread implements Runnable {

    @Override
    public void run() {
      new Order().order();
      new Stock().stockUpdate();
    }
  }

}
