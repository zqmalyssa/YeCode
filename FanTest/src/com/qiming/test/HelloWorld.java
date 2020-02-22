package com.qiming.test;

public class HelloWorld {

  public static void main(String args[]) {

    State s = new StateImpl();

    MyThread m = new MyThread();
    m.run();
    System.out.println("after thread");
  }

  private static void test(User user) {
    user.setAge(1);
  }

}
