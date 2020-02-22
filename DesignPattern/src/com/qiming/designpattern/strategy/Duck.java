package com.qiming.designpattern.strategy;

/**
 * Duck是父类，有很多子类去继承，有公共的方法
 */

public abstract class Duck {

  /**
   * 这本来是Duck的功能，现在被抽了出来
   */
  FlyBehavior flyBehavior;
  QuackBehavior quackBehavior;

  public void swim() {
    System.out.println("我们鸭子都能游泳");
  }

  /**
   * swim是都有的，display做成抽象
   */
  public abstract void display();

  /**
   * 下面两个方法取代了quack和fly
   */
  public void performQuack() {
    quackBehavior.quack();
  }

  public void performFly() {
    flyBehavior.fly();
  }

  /**
   * 继续开放动态行为的设定，让程序在运行时可以修改行为
   */
  public void setFlyBehavior(FlyBehavior fb) {
    this.flyBehavior = fb;
  }

  public void setQuackBehavior(QuackBehavior qb) {
    this.quackBehavior = qb;
  }

}
