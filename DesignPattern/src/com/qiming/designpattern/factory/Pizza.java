package com.qiming.designpattern.factory;

import java.util.ArrayList;

/**
 * Pizza的抽象，这里是个抽象类，不是接口
 */
public abstract class Pizza {

  String name;
  String dough; //面团
  String sauce; //酱料
  ArrayList toppings = new ArrayList();

  //如果是工厂模式，打开下面新的属性
//  Dough dough;
//  Sauce sauce;
//  Veggies veggies[];
//  Cheese cheese;
//  Pepperoni pepperoni;
//  Clams clam;

  public void prepare() {
    System.out.println("Preparing " + name);
    System.out.println("Tossing dough...");
    System.out.println("Adding sauce...");
    System.out.println("Adding toppings: ");
    for (int i = 0; i < toppings.size(); i++) {
      System.out.println("   " + toppings.get(i));
    }
  }

  //如果是工厂模式，打开下面这个抽象方法
//  abstract public void prepare();

  public void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  public void cut() {
    System.out.println("Cutting the Pizza into diagonal slices");
  }

  public void box() {
    System.out.println("Place pizza in official PizzaStore box");
  }

  public String getName() {
    return name;
  }

  //如果是工厂模式，再写个setName的方法
  public void setName(String name) {
    this.name = name;
  }

}
