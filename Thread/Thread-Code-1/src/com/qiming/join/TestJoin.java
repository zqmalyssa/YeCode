package com.qiming.join;

/**
 * 测试join的作用
 * join的作用是使所属的线程对象x正常执行run()方法中的任务，而使当前线程z进行无限期的阻塞，等待线程x销毁后再执行线程z后面的代码
 * 方法join具有使线程排队运行的作用，有些类似同步的运行效果，join和synchronized的区别是join在内部使用wait()方法，而synchronized关键字使用的是"对象监视器"
 */
public class TestJoin {

  public static void main(String[] args) {
    try {
      MyThread threadTest = new MyThread();
      threadTest.start();
      threadTest.join();
      System.out.println("我想当threadTest对象执行完毕后我再执行，我做到了");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
