package com.qiming.errorexample;

public class Stock {

  private static int STOCK_NUM = 3;

  /**
   *
   * 存在这样的情况
   *
   * User1下单成功。。。
   * User2下单成功。。。
   * User1减库存成功
   * User2减库存成功
   *
   * 我觉得加上syn就不会出这个问题了，而且是static去锁类对象，因为后面是new出新对象的，测试这样应该是没问题的
   *
   *
   * @return
   */
  public static synchronized boolean stockUpdate() {
    if (STOCK_NUM > 0) {
      STOCK_NUM--;
      System.out.println(Thread.currentThread().getName() + "减库存成功");
      return true;
    } else {
      System.out.println(Thread.currentThread().getName() + "减库存失败");
      return false;
    }
  }

}
