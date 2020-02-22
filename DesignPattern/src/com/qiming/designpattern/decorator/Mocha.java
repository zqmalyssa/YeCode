package com.qiming.designpattern.decorator;

/**
 * 写个具体的装饰者，Mocha装饰者类
 */
public class Mocha extends CondimentDecorator {

  //用一个实例变量记录饮料，也就是被装饰者
  Beverage beverage;

  public Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Mocha";
  }

  @Override
  public double cost() {
    return .20 + beverage.cost();
  }
}
