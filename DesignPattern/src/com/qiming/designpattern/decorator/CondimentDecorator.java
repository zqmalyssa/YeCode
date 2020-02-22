package com.qiming.designpattern.decorator;

/**
 * 调料抽象类，这就叫作装饰者类，是一个抽象类，继承超类
 */

public abstract class CondimentDecorator extends Beverage{

  //所有的调料装饰者都必须重新实现getDescription方法
  public abstract String getDescription();
}
