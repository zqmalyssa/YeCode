package com.qiming.concurrent;

/**
 * 测试condition的awaituntil和
 * 线程在等待时间到达前，可以被其他线程提前唤醒
 */

public class RunTest {

  public static void main(String[] args) throws InterruptedException{
    Service service = new Service();
    //测试1
//    MyThreadA myThreadA = new MyThreadA(service);
    //测试2
//    myThreadA.start();
    MyThreadA myThreadA = new MyThreadA(service);
    myThreadA.start();
    Thread.sleep(2000);
    MyThreadB myThreadB = new MyThreadB(service);
    myThreadB.start();
  }

}
