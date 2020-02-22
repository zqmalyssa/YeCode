package com.qiming.designpattern.strategy;

/**
 * 策略模式，把飞行这种动作独立出来，可以被其他对象复用，因为这些行为已经和鸭子无关了
 */

public interface FlyBehavior {

  public void fly();

}
