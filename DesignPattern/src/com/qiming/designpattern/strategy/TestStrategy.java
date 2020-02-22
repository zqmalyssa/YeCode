package com.qiming.designpattern.strategy;

public class TestStrategy {

  public static void main(String[] args) {
    /**
     * 简单测试一下
     */
    Duck mallard = new MallardDuck();
    mallard.performFly();
    mallard.performQuack();

    /**
     * 动态测试
     */
    Duck model = new ModelDuck();
    model.performFly();
    //改变了模型鸭的飞行方式
    model.setFlyBehavior(new FlyWithRocket());
    model.performFly();
  }

}
