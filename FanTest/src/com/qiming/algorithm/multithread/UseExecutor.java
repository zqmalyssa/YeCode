package com.qiming.algorithm.multithread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用线程池设计读写锁
 *
 * 与传统锁不同的是读写锁的规则是可以共享读，但只能一个写，总结起来为：读读不互斥，读写互斥，写写互斥，而一般的独占锁是：
 * 读读互斥，读写互斥，写写互斥，而场景中往往读远远大于写，读写锁就是为了这种优化而创建出来的一种机制。注意是读远远大于写
 *
 *
 *
 */
public class UseExecutor {

  private static ExecutorService pool;
  private static int number = 0;

  private final MyReadWriterLock lock = new MyReadWriterLock();

  //创建一个共享数据对象，用于读写操作
  private final char[] buffer;

  public UseExecutor(int size) {
    this.buffer = new char[size];
    for (int i = 0; i < buffer.length; i++) {
      buffer[i] = '*';
    }
  }

  public char[] read() {
    try {
      lock.lockRead();
      return this.doRead();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlockRead();
    }
    return new char[0];
  }

  public void write(char c) {
    try {
      lock.lockWriter();
      this.doWrite(c);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlockWriter();
    }
  }

  private void doWrite(char c) {
    for (int i = 0; i < buffer.length; i++) {
      buffer[i] = c;
      slowly(10);
    }
  }

  private char[] doRead() {
    char[] newBuf = new char[buffer.length];
    for (int i = 0; i < buffer.length; i++) {
      newBuf[i] = buffer[i];
    }
    slowly(500);
    return newBuf;
  }

  private void slowly(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

//  public static void main(String[] args) {
//
//    pool = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(),
//        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//
//    //三个读线程
//    for (int i = 0; i < 3; i++) {
//      pool.execute(new Runnable() {
//        @Override
//        public void run() {
//          try {
//            lock.lockRead();
//            System.out.println("我是读线程" + Thread.currentThread().getName() + "目前的number值是" +  + number);
//          } catch (Exception e){
//            e.printStackTrace();
//          } finally {
//            lock.unlockRead();
//          }
//        }
//      });
//    }
//
//
//    //一个写线程
//    for (int i = 0; i < 3; i++) {
//      pool.execute(new Runnable() {
//        @Override
//        public void run() {
//          try {
//            lock.lockWriter();
//            number--;
//            System.out.println("我是写线程" + Thread.currentThread().getName() + "目前的number值是" +  + number);
//          } catch (Exception e){
//            e.printStackTrace();
//          } finally {
//            lock.unlockWriter();
//          }
//        }
//      });
//    }
//
//
//    pool.shutdown();
//  }

}

/**
 * 模拟读写锁
 */
class MyReadWriterLock {

  /**
   * 读锁持有个数
   */
  private volatile int read;
  /**
   * 写锁持有个数
   */
  private volatile int write;

  public MyReadWriterLock() {
    this.read = 0;
    this.write = 0;
  }

  /**
   * 获取读锁，读锁在写锁不存在的时候才能获取
   * @throws InterruptedException
   */
  public synchronized void lockRead() throws InterruptedException {
    while (write > 0) {
      this.wait();
    }
    this.read++;
  }

  /**
   * 释放读锁
   */
  public synchronized void unlockRead() {
    read--;
    this.notifyAll();
  }

  /**
   * 获取写锁，当读锁，写锁都有时，wait()
   * @throws InterruptedException
   */
  public synchronized void lockWriter() throws InterruptedException{
    while (read > 0 || write > 0) {
      this.wait();
    }
    this.write++;
  }

  /**
   * 释放写锁
   */
  public synchronized void unlockWriter() {
    this.write--;
    this.notifyAll();
  }


}
