package com.qiming.designpattern.strategy;

public class FlyNoWay implements FlyBehavior{

  @Override
  public void fly() {
    System.out.println("我不能飞翔");
  }
}
