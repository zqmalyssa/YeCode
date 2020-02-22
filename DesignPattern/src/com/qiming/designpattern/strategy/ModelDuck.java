package com.qiming.designpattern.strategy;

public class ModelDuck extends Duck {

  public ModelDuck() {
    flyBehavior = new FlyNoWay();
    quackBehavior = new Quack();
  }

  @Override
  public void display() {
    System.out.println("其实，我是一只帅气的模型鸭");
  }
}
