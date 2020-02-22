package com.qiming.test.genericity;

import java.util.ArrayList;
import java.util.List;

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class CovriantArrays {
  public static void main(String[] args) {
    Fruit[] fruit = new Apple[10];
    fruit[0] = new Apple();
    fruit[1] = new Jonathan();

    /**
     * 这边拿出去就会报错
     */
    try {
      fruit[2] = new Fruit();
    }catch (Exception e) {
      System.out.println(e);
    }

    /**
     * 这边拿出去就会报错
     */
    try {
      fruit[3] = new Orange();
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println(fruit.getClass().getSimpleName());

    List<? extends Fruit> fList = new ArrayList<Apple>();
//    fList.add(new Apple());
//    fList.add(new Fruit());
//    fList.add(new Object());

    Fruit f = fList.get(0);

  }




}