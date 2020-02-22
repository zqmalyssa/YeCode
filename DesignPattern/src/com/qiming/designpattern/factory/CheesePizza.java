package com.qiming.designpattern.factory;

public class CheesePizza extends Pizza{

  PizzaIngredientFactory ingredientFactory;

  /**
   * 要制作Pizza，就要工厂提供原料，所以每个Pizza类都需要从构造器参数中得到一个工厂，并把这个工厂存储在一个实例变量中
   * @param ingredientFactory
   */
  public CheesePizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  /**
   * 这边是实现Pizza里面的抽象prepare方法，改造后的
   *
   * 怎么去创建这些原料由你投的哪个工厂决定
   */

  @Override
  public void prepare() {
    System.out.println("Preparing " + name);
//    dough = ingredientFactory.createDough();
//    sauce = ingredientFactory.createSauce();
//    cheese = ingredientFactory.createCheese();
//    clam = ingredientFactory.createClam();
  }
}
