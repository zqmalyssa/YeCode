package com.qiming.test.genericity;

import java.util.Arrays;
import java.util.List;

public class GenericReading {

  //Arrays.asList()生成大小不可变的列表
  static List<Apple> apples = Arrays.asList(new Apple());
  static List<Fruit> fruits = Arrays.asList(new Fruit());

  //使用“精确”的泛型
  static class Reader<T> {
    T readExact(List<T> list) {
      System.out.println(list.get(0).getClass().getSimpleName());
      return list.get(0);
    }
  }

  static void f1() {
    Reader<Fruit> fruitReader = new Reader<Fruit>();
    Fruit f = fruitReader.readExact(fruits);
//      Fruit a = fruitReader.readExact(apples);   //Error
  }

  //协变
  static class CovariantReader<T> {
    //可以接受T类型或者是T导出的类型
    T readCovariant(List<? extends T> list) {
      System.out.println(list.get(0).getClass().getSimpleName());
      return list.get(0);
    }
  }

  static void f2() {
    CovariantReader<Fruit> fReader = new CovariantReader<>();
    Fruit f = fReader.readCovariant(fruits);
    Fruit a = fReader.readCovariant(apples);
  }

  public static void main(String[] args) {
    f1();
    System.out.println("---");
    f2();
  }

}
