package com.qiming.designpattern.decorator;

/**
 * 写一些饮料，深焙咖啡
 */

public class DarkRoast extends Beverage{

  public DarkRoast() {
    description = "DarkRoast Coffee";
  }

  @Override
  public double cost() {
    return .99;
  }
}
