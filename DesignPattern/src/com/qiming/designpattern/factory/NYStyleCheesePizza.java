package com.qiming.designpattern.factory;

public class NYStyleCheesePizza extends Pizza{

  public NYStyleCheesePizza() {
    name = "NY Style Sauce and Cheese Pizza";
    dough = "Thin Crust Dough";
    sauce = "Marinara Sause";

    toppings.add("Grated Reggiano Cheese");
  }
}
