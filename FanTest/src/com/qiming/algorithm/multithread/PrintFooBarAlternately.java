package com.qiming.algorithm.multithread;

import java.util.concurrent.Semaphore;

/**
 * 交替打印FooBar
 *
 * 我们提供一个类：
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 输入: n = 2  输出: "foobarfoobar"  解释: "foobar" 将被输出两次。
 *
 * 思路：信号量做一波
 *
 */
public class PrintFooBarAlternately {

  private int n;

  private Semaphore fooSema = new Semaphore(1);
  private Semaphore barSema = new Semaphore(0);

  public PrintFooBarAlternately(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      fooSema.acquire();
      // printFoo.run() outputs "foo". Do not change or remove this line.
      printFoo.run();
      barSema.release();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      barSema.acquire();
      // printBar.run() outputs "bar". Do not change or remove this line.
      printBar.run();
      fooSema.release();
    }
  }

}
