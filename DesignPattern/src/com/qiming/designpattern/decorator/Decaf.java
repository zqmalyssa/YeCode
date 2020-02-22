package com.qiming.designpattern.decorator;

/**
 * 写一些饮料，低咖啡因
 */

public class Decaf extends Beverage{

  public Decaf() {
    description = "Decaf Coffee";
  }

  @Override
  public double cost() {
    return 1.05;
  }
}
