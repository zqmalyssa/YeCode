package com.qiming.designpattern.singleton;

public class DCLSingleton {

  //volatile关键字是为了解决多线程环境下指令重排
  private volatile static DCLSingleton dclSingleton;

  private DCLSingleton() {}

  //多线程环境中，不用在方法上加syn，只有第一次执行此方法，才需要真正同步
  public static DCLSingleton getInstance() {
    //双重锁是为了解决速度问题
    if (dclSingleton == null) {
      synchronized (DCLSingleton.class) {
        if (dclSingleton == null) {
          dclSingleton = new DCLSingleton();
        }
      }
    }
    return dclSingleton;
  }

}

