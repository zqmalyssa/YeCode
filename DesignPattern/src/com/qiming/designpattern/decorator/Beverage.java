package com.qiming.designpattern.decorator;

/**
 * 装饰者模式详解，饮料是抽象类，是所有类的超类
 *
 * 包括装饰者和被装饰者
 */

public abstract class Beverage {

  String description = "Unknown Beverage";

  public String getDescription() {
    return description;
  }

  public abstract double cost();

}
