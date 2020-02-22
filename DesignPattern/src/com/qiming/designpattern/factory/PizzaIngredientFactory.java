package com.qiming.designpattern.factory;

/**
 * 用Pizza的原料来设计一个原料工厂，主要是说明抽象工厂模式，这区别于工厂方法模式
 */

public interface PizzaIngredientFactory {

  public Dough createDough();
  public Sauce createSauce();
  public Cheese createCheese();
  public Veggies[] createVeggies();
  public Pepperoni createPepperoni();
  public Clams createClam();

}
