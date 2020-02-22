package com.qiming.algorithm.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ReadWriteLockClient {

  /**
   * 使用线程池
   */
  private static ExecutorService pool;

  public static void main(String[] args) {

    pool = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(),
        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    final UseExecutor useExecutor= new UseExecutor(10);
//    new ReadWorker(useExecutor).start();
//    new ReadWorker(useExecutor).start();
//    new ReadWorker(useExecutor).start();
//    new ReadWorker(useExecutor).start();
//    new ReadWorker(useExecutor).start();
//
//    new WriterWork(useExecutor, "ddjifjsidjfisd").start();
//    new WriterWork(useExecutor, "DDJIFJSIDJFISD").start();

    //启动多个读线程
    for (int i = 0; i < 5; i++) {
      pool.execute(new ReadWorker(useExecutor));
    }

    //启动较少的写线程
    pool.execute(new WriterWork(useExecutor, "ddjifjsidjfisd"));
    pool.execute(new WriterWork(useExecutor, "DDJIFJSIDJFISD"));

    pool.shutdown();
  }

}
