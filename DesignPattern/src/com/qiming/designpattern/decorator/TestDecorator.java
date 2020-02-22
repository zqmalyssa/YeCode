package com.qiming.designpattern.decorator;

public class TestDecorator {

  public static void main(String[] args) {
    //不做任何装饰
    Beverage beverage = new Espresso();
    System.out.println(beverage.getDescription() + " $" + beverage.cost());

    //进行装饰
    Beverage beverage2 = new DarkRoast();
    beverage2 = new Mocha(beverage2);
    beverage2 = new Mocha(beverage2);
    beverage2 = new Whip(beverage2);
    System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    //进行装饰
    Beverage beverage3 = new HouseBlend();
    beverage3 = new Soy(beverage3);
    beverage3 = new Mocha(beverage3);
    beverage3 = new Whip(beverage3);
    System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

  }

}
