package com.qiming.algorithm.multithread;

public class ReadWorker extends Thread{

  private final UseExecutor useExecutor;

  public ReadWorker(UseExecutor useExecutor) {
    this.useExecutor = useExecutor;
  }

  @Override
  public void run() {
    while (true) {
      char[] readBuffer = useExecutor.read();
      System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuffer));
    }
  }
}
