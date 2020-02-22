package com.qiming.designpattern.strategy;

public class FlyWithRocket implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("我用火箭飞");
  }
}
