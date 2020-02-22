package com.qiming.concurrent.threadpoolexecutor.callable;

import java.util.concurrent.Callable;

public class CallableTest implements Callable {

  @Override
  public String call() {
    try {
      String a = "return a string";
      return a;
    } catch (Exception e) {
      e.printStackTrace();
      return "exception";
    }
  }
}
