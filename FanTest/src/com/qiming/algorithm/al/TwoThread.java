package com.qiming.algorithm.al;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 12A34B56C78D910E1112F1314G1516H1718I1920J2122K
 */
public class TwoThread {

  private static int count = 0;

  public static void main(String[] args) {

    //初始化可重入锁
    final Lock lock = new ReentrantLock();

    final Condition conditionA = lock.newCondition();
    final Condition conditionB = lock.newCondition();

    final String str = "12A34B56C78D910E1112F1314G1516H1718I1920J2122K";

    //打印数字的线程
    Thread threadA = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          lock.lock();
          for (int i = 0; i < str.length(); i++) {
            while (count % 2 != 0) {
              conditionA.await();
            }
            if (Character.isDigit(str.charAt(i))) {
              System.out.print(str.charAt(i));
            }
            count++;
            conditionB.signal();
          }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }

      }
    }
    );

    //打印字符的线程
    Thread threadB = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          lock.lock();
          for (int i = 0; i < str.length(); i++) {
            while (count % 2 != 1) {
              conditionB.await();
            }
            if (!Character.isDigit(str.charAt(i))) {
              System.out.print(str.charAt(i));
            }
            count++;
            conditionA.signal();
          }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      }
    });

    //启动两个线程
    threadA.setName("打印数字线程");
    threadB.setName("打印字符线程");
    threadA.start();
    threadB.start();


  }

}
