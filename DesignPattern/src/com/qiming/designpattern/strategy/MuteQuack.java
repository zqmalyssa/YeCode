package com.qiming.designpattern.strategy;

public class MuteQuack implements QuackBehavior{

  @Override
  public void quack() {
    System.out.println("我不会叫");
  }
}
