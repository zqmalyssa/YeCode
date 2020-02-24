package com.qiming.algorithm.multithread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 交替打印字符串
 *
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 思路：用信号量去做，注意number这个很关键，自我释放锁
 *
 */
public class FizzBuzzMultithreaded {

  private int n;

  private volatile static int flag = 1;

  private static Semaphore fizzSem = new Semaphore(0);
  private static Semaphore buzzSem = new Semaphore(0);
  private static Semaphore fizzBuzzSem = new Semaphore(0);
  private static Semaphore numSem = new Semaphore(1);

  public FizzBuzzMultithreaded(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {

  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {

  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {

  }

  public static void main(String[] args) {

    int m = 15;

    Thread threadFizz = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 3; i <= m; i = i + 3) {
          if (i % 5 != 0) {
            try {
              fizzSem.acquire();
              System.out.println("fizz");
              numSem.release();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });

    Thread threadBuzz = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 5; i <= m; i = i + 5) {
          if (i % 3 != 0) {
            try {
              buzzSem.acquire();
              System.out.println("buzz");
              numSem.release();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });

    Thread threadFizzBuzz = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 15; i <= m; i = i + 15) {
          try {
            fizzBuzzSem.acquire();
            System.out.println("fizzbuzz");
            numSem.release();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    /**
     * 重点是number这个，有个自我解锁
     */
    Thread threadNumber = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i <= m; i++) {
          try {
            numSem.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
              fizzBuzzSem.release();
            }else if (i % 3 == 0) {
              fizzSem.release();
            }else if (i % 5 == 0) {
              buzzSem.release();
            }else {
              System.out.println(i);
              numSem.release();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    threadFizz.start();
    threadBuzz.start();
    threadFizzBuzz.start();
    threadNumber.start();
  }

}
