package com.qiming.designpattern.strategy;

public class FlyWithWings implements FlyBehavior{

  @Override
  public void fly() {
    System.out.println("我用翅膀飞翔");
  }
}
