package com.qiming.test;

//方式3，双重检查枷锁，单例防止线程异常

public class Elvis3 {

  private volatile static Elvis3 unique;

  private Elvis3() {} //注意private的写法

  public static Elvis3 getInstance() {
    if (unique == null) {
      synchronized (Elvis3.class) {
        if (unique == null) {
          unique = new Elvis3();
        }
      }
    }
    return unique;
  }

}
