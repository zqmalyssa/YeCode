package com.qiming.algorithm.multithread;

import java.util.Random;

public class WriterWork extends Thread {

  private static final Random random = new Random(System.currentTimeMillis());

  private final UseExecutor useExecutor;
  private final String filler;
  private int index;

  public WriterWork(UseExecutor useExecutor, String filler) {
    this.useExecutor = useExecutor;
    this.filler = filler;
  }


  @Override
  public void run() {
    try {
      while (true) {
        char c = nextChar();
        useExecutor.write(c);
        Thread.sleep(random.nextInt(1000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public char nextChar() {
    char c = filler.charAt(index);
    index++;
    if (index >= filler.length()) {
      index = 0;
    }
    return c;
  }
}
