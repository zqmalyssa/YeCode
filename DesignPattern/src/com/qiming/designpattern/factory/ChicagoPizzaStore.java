package com.qiming.designpattern.factory;

/**
 * 创建一个有纽约风味的PizzaStore，必须实现createPizza()方法，因为它是抽象的
 */
public class ChicagoPizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new ChicagoStyleCheesePizza();
//    } else if (type.equals("veggie")) {
//      return new ChicagoStyleVeggiePizza();
//    } else if (type.equals("clam")) {
//      return new ChicagoStyleClamPizza();
//    } else if (type.equals("pepperoni")) {
//      return new ChicagoStylePepperoniPizza();
    } else {
      return null;
    }
  }
}
