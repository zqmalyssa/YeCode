package com.qiming.errorexample;

/**
 * 下一个订单，然后再减库存
 */
public class Order {

  public void order() {
    System.out.println(Thread.currentThread().getName() + "下单成功。。。");
  }

}
