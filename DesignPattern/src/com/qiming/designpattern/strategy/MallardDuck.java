package com.qiming.designpattern.strategy;

/**
 * 野鸭类，继承自鸭类Duck，看看它的行为
 */

public class MallardDuck extends Duck{

  /**
   * 野鸭是呱呱叫和用翅膀飞翔
   */
  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }

  @Override
  public void display() {
    System.out.println("其实，我是一只帅气的野鸭");
  }
}
