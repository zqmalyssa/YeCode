package com.qiming.designpattern.decorator;

/**
 * 写个具体的装饰者，Soy装饰者类
 */
public class Soy extends CondimentDecorator{

  //用一个实例变量记录饮料，也就是被装饰者
  Beverage beverage;

  public Soy(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Soy";
  }

  @Override
  public double cost() {
    return .15 + beverage.cost();
  }
}
