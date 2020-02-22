package com.qiming.designpattern.decorator;

/**
 * 写个具体的装饰者，Whip装饰者类
 */
public class Whip extends CondimentDecorator{

  //用一个实例变量记录饮料，也就是被装饰者
  Beverage beverage;

  public Whip(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Whip";
  }

  @Override
  public double cost() {
    return .10 + beverage.cost();
  }
}
