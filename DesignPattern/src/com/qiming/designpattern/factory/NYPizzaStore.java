package com.qiming.designpattern.factory;

/**
 * 创建一个有纽约风味的PizzaStore，必须实现createPizza()方法，因为它是抽象的
 */
public class NYPizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new NYStyleCheesePizza();
//    } else if (type.equals("veggie")) {
//      return new NYStyleVeggiePizza();
//    } else if (type.equals("clam")) {
//      return new NYStyleClamPizza();
//    } else if (type.equals("pepperoni")) {
//      return new NYStylePepperoniPizza();
    } else {
      return null;
    }

    /**
     * 下面是将上面的方式替换成抽象工厂模式
     */
//    Pizza pizza = null;
//    //把工厂传递给一个Pizza，以便Pizza能从工厂中取得原料
//    PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
//    if (type.equals("cheese")) {
//      pizza = new CheesePizza(ingredientFactory);
//      pizza.setName("New York Style Cheese Pizza");
//    }
//    return pizza;

  }
}
