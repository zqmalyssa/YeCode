package com.qiming.designpattern.factory;

/**
 * 现在的PizzaStore是抽象的
 */
public abstract class PizzaStore {

  public Pizza orderPizza(String type) {
    Pizza pizza;

    pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  /**
   * 在PizzaStore里，工厂方法是抽象的
   *
   * 原本是由一个对象负责所有具体类的实例化，现在通过对PizzaStore做一些小转变，变成由一群子类来负责实例化
   * @param type
   * @return
   */
  abstract Pizza createPizza(String type);

}
