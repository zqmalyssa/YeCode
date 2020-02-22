package com.qiming.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个场景，两个线程数数，同时启动两个线程，线程A数1、2、3，然后线程B数4、5、6，最后线程A数7、8、9，程序结束，
 * 这涉及到线程之间的通信，但是
 * 下面这段场景有一定的概率无法执行下去
 */

public class ConditionTest {

  static class NumberWrapper {
    public int value = 1;
  }

  public static void main(String[] args) {
//    try {
//      Thread.sleep(10000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    //初始化可重入锁
    final Lock lock = new ReentrantLock();

    //第一个条件当屏幕上输出到3
    final Condition reachThreeCondition = lock.newCondition();

    //第一个条件当屏幕上输出到6
    final Condition reachSixCondition = lock.newCondition();

    //NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final :)
    //注意这里不要用Integer, Integer 是不可变对象
    final NumberWrapper num = new NumberWrapper();
    //初始化A线程
    Thread threadA = new Thread(
        new Runnable() {
          @Override
          public void run() {
            //需要先获得锁
            lock.lock();
            System.out.println("ThreadA获得lock");
            try {
              System.out.println("ThreadA start write");
              //A线程先输出前3个数
              while (num.value <= 3) {
                System.out.println(num.value);
                num.value++;
              }
              //输出到3的时候要signal，告诉B线程可以开始了
              reachThreeCondition.signal();
            } catch (Exception e) {
              e.printStackTrace();
            } finally {
              lock.unlock();
              System.out.println("ThreadA释放了lock");
            }

            lock.lock();
            try {
              //等到输出6的条件
              System.out.println("ThreadA获得lock");
//              while (num.value <= 6) {
//                reachSixCondition.await();
//              }
              //改成if呢，一样吧
              if (num.value <= 6) {
                reachSixCondition.await();
              }
              System.out.println("ThreadA start write");
              //输出剩余的数字
              while (num.value <= 9) {
                System.out.println(num.value);
                num.value++;
              }
            } catch (InterruptedException e) {
              e.printStackTrace();
            } finally {
              lock.unlock();
              System.out.println("ThreadA释放了lock");
            }
          }
        }
    );

    Thread threadB = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          lock.lock();
          System.out.println("ThreadB获得lock");
          Thread.sleep(5000);  //停顿时间
//          while (num.value <= 3) {
//            //等待3输出完毕的信号
//            reachThreeCondition.await();
//          }
          //改成if呢，一样吧
          if (num.value <= 3) {
            reachThreeCondition.await();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
          System.out.println("ThreadB释放lock");
        }

        try {
          lock.lock();
          System.out.println("ThreadB获得lock");
          //已经收到信号，开始输出4/5/6
          System.out.println("threadB start write");
          while (num.value <= 6) {
            System.out.println(num.value);
            num.value++;
          }
          //4/5/6输出完毕，告诉A线程6输出完了
          reachSixCondition.signal();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
          System.out.println("ThreadB释放lock");
        }
      }
      });

    //启动两个线程
    threadA.setName("threadA");
    threadB.setName("threadB");
    threadA.start();
    threadB.start();

    }
}
