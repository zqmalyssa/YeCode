package com.qiming.concurrent.threadpoolexecutor.callable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMain {

  public static void main(String[] args) {
    //创建线程池，默认都是这样创建
    ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), Executors
        .defaultThreadFactory(), new AbortPolicy());
    Future<String> future = tpe.submit(new CallableTest());

    try {
      System.out.println(future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } finally {
      tpe.shutdown();
    }

  }

}
