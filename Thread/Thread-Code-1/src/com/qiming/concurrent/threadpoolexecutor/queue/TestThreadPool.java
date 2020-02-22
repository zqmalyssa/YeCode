package com.qiming.concurrent.threadpoolexecutor.queue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadPool {

  public static void main(String args[]) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future future = executorService.submit(new Runnable() {
      public void run() {
        System.out.println("Asynchronous task");
      }
    });
    //如果任务结束执行则返回 null
    try {
      System.out.println("future.get()=" + future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    Future future1 = executorService.submit(new Callable(){
      public Object call() throws Exception {
        System.out.println("Asynchronous Callable");
        return "Callable Result";
      }
    });

    try {
      System.out.println("future.get() = " + future1.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    executorService.shutdown();

  }

}
