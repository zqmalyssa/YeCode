package com.qiming.test.lambda;

public class TestAnonymousInnerClass {

  public static void main(String[] args) {

    //使用普通的方式创建
    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("普通方式创建!");
      }
    };

    //使用拉姆达方式创建
    Runnable r2 = ()-> System.out.println("拉姆达方式创建!");

    new Thread(r1).start();
    new Thread(r2).start();

  }

}
