package com.qiming.concurrent.reentrantreadwritelock;

/**
 * 可以看到几乎是同时获得读锁
 */

public class TestReenRWLock {

  public static void main(String[] args) {
    Service service = new Service();
    ThreadA a = new ThreadA(service);
    a.setName("A");
    ThreadB b = new ThreadB(service);
    b.setName("B");
    a.start();
    b.start();
  }

}
