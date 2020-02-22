package com.qiming.designpattern.strategy;

public class Quack implements QuackBehavior{

  @Override
  public void quack() {
    System.out.println("我在呱呱叫");
  }

}
