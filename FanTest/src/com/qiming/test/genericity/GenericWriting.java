package com.qiming.test.genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {

  static List<Apple> apples = new ArrayList<Apple>();
  static List<Fruit> fruits = new ArrayList<Fruit>();

  static <T> void writeExact(List<T> list, T item) {
    System.out.println(item.getClass().getSimpleName());
    list.add(item);
  }

  //在“精确”类型下 也可以向fruit中添加对象
  static void f1() {
    writeExact(fruits, new Fruit());
    writeExact(fruits, new Apple());
    writeExact(fruits, new Orange());
//      writeExact(fruits, new Object()); //Error
  }

  static <T> void writeWithWildcard(List<? super T> list, T item) {
    System.out.println(item.getClass().getSimpleName());
    list.add(item);
  }

  static void f2() {
    writeWithWildcard(fruits, new Fruit());
    writeWithWildcard(fruits, new Apple());
    writeWithWildcard(fruits, new Orange());
//      writeWithWildcard(fruits, new Object()); //Error
  }

  public static void main(String[] args) {
    f1();
    System.out.println("--------------");
    f2();
  }

}
