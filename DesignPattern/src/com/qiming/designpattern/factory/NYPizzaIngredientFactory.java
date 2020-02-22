package com.qiming.designpattern.factory;

/**
 * 创建纽约的原料工厂，实现原料工厂接口
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

  @Override
  public Dough createDough() {
    return new ThinCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new MarinaraSauce();
  }

  @Override
  public Cheese createCheese() {
    return new ReggianoCheese();
  }

  @Override
  public Veggies[] createVeggies() {
    Veggies[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    return veggies;
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clams createClam() {
    return new FreshClams();
  }
}
