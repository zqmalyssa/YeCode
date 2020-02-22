package com.qiming.algorithm.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印零与奇偶数
 *
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 *
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 * 思路，lock的condition正常写，但是会有超时，不加锁去写，有volatile写法和Semaphore(模拟锁)写法
 *
 */
public class PrintZeroEvenOdd {

  private static int n = 5;
  private static int index;

  //0代表zero，1代表odd，2代表偶数
  private static volatile int flag = 0;

  public PrintZeroEvenOdd(int n) {
    this.n = n;
  }


  public static void main(String[] args) {

    Semaphore zero = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
    Semaphore even = new Semaphore(0);

    /**
     * 以下用锁方法会超时
     */
//    final Lock lock = new ReentrantLock();
//
//    final Condition conditionZero = lock.newCondition();
//    final Condition conditionNum = lock.newCondition();
//
//    //打印0的线程
//    Thread threadA = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          lock.lock();
//          for (int i = 0; i < n; i++) {
//            while (index % 2 != 0) {
//              conditionZero.await();
//            }
//            System.out.print(0);
//            index++;
//            conditionNum.signalAll();
//          }
//        } catch (Exception e) {
//          e.printStackTrace();
//        } finally {
//          lock.unlock();
//        }
//
//      }
//    }
//    );
//
//    //打印奇数的线程
//    Thread threadB = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          lock.lock();
//          for (int i = 1; i <= n; i = i + 1) {
//            while (index % 2 != 1 || (index + 1) % 2 != 0) {
//              conditionNum.await();
//            }
//            System.out.print(i);
//            index++;
//            conditionZero.signal();
//          }
//        } catch (Exception e) {
//          e.printStackTrace();
//        } finally {
//          lock.unlock();
//        }
//      }
//    });
//
//    //打印偶数的线程
//    Thread threadC = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          lock.lock();
//          for (int i = 2; i <= n; i = i + 2) {
//            while (index % 2 != 1 || (index + 1) % 2 != 1) {
//              conditionNum.await();
//            }
//            System.out.print(i);
//            index++;
//            conditionZero.signal();
//          }
//        } catch (Exception e) {
//          e.printStackTrace();
//        } finally {
//          lock.unlock();
//        }
//      }
//    });

    /**
     * 没有lock的写法，用到volatile
     */
    //打印0的线程
//    Thread threadA = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        for (int i = 0; i < n; i++) {
//          while (flag != 0) {
//            Thread.yield();
//          }
//          System.out.print(0);
//          //这样想，i只控制0输出后是奇数还是偶数就行了
//          if (i % 2 != 0) {
//            flag = 2;
//          } else {
//            flag = 1;
//          }
//        }
//
//      }
//    }
//    );
//
//    Thread threadB = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        for (int i = 1; i <= n; i= i+2) {
//          while (flag != 1) {
//            Thread.yield();
//          }
//          System.out.print(i);
//          flag = 0;
//        }
//
//      }
//    }
//    );
//
//    Thread threadC = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        for (int i = 2; i <= n; i= i+2) {
//          while (flag != 2) {
//            Thread.yield();
//          }
//          System.out.print(i);
//          flag = 0;
//        }
//
//      }
//    }
//    );

    /**
     * 使用信号量的方法
     */
    //打印0的线程
    Thread threadA = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < n; i++) {
          try {
            zero.acquire();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.print(0);
          //这样想，i只控制0输出后是奇数还是偶数就行了
          if (i % 2 != 0) {
            even.release();
          } else {
            odd.release();
          }
        }

      }
    }
    );

    //打印奇数的线程
    Thread threadB = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i <= n; i= i+2) {
          try {
            odd.acquire();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.print(i);
          zero.release();
        }

      }
    }
    );

    //打印偶数的线程
    Thread threadC = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 2; i <= n; i=i+2) {
          try {
            even.acquire();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.print(i);
          zero.release();
        }

      }
    }
    );

    threadA.setName("打印zero线程");
    threadB.setName("打印奇数线程");
    threadC.setName("打印偶数线程");

    threadA.start();
    threadB.start();
    threadC.start();

  }
}
