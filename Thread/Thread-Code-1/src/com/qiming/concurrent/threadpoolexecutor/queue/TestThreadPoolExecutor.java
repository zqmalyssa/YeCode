package com.qiming.concurrent.threadpoolexecutor.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这段主要测试queue在ThreadPoolExecutor中的作用
 * 分别使用SynchronousQueue和ArrayBlockingQueue
 * 如果程序改成new ArrayBlockingQueue<Runnable>(10)，则被拒绝的任务数是390，被执行的是610，之前是600，因为queue中多了10
 */

public class TestThreadPoolExecutor {

  final BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();

  //搞清构造函数的每个参数
  final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 600, 30, TimeUnit.SECONDS, queue,
      Executors.defaultThreadFactory(), new AbortPolicy());

  final AtomicInteger completedTask = new AtomicInteger(0);

  final AtomicInteger rejectedTask = new AtomicInteger(0);

  static long beginTime;
  final int count = 1000;

  public static void main(String args[]) {
    beginTime = System.currentTimeMillis();
    TestThreadPoolExecutor demo = new TestThreadPoolExecutor();
    demo.start();
  }

  public void start(){
    CountDownLatch latch = new CountDownLatch(count);
    CyclicBarrier barrier = new CyclicBarrier(count);
    for (int i = 0; i < count; i++) {
      new Thread(new TestThread(latch, barrier)).start();
    }

  }

  class TestThread implements Runnable{

    private CountDownLatch latch;
    private CyclicBarrier barrier;

    public TestThread(CountDownLatch latch, CyclicBarrier barrier) {
      this.latch = latch;
      this.barrier = barrier;
    }

    @Override
    public void run() {
      try {
        barrier.await();
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        executor.execute(new Task(latch));
      } catch (RejectedExecutionException exception) {
        latch.countDown();
        System.err.println("被拒绝的任务数为：" + rejectedTask.incrementAndGet());
      }
    }
  }

  class Task implements Runnable{
    private CountDownLatch latch;

    public Task(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void run() {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("执行的任务数为： " + completedTask.incrementAndGet());
      System.out.println("任务耗时为： " + (System.currentTimeMillis() - beginTime) + "ms");
      latch.countDown();
    }
  }

}


