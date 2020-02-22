package com.qiming.test.genericity.method;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法的使用例子
 */
public class GenericMethods {

  public <T> void f(T x) {
    System.out.println(x.getClass().getName());
  }

  public static <T> List<T> makeList(T... args) {
    List<T> result = new ArrayList<T>();
    for (T item : args) {
      result.add(item);
    }
    return result;
  }

  public static void main(String[] args) {
    GenericMethods gm = new GenericMethods();
    gm.f("");
    gm.f(1);
    gm.f(1.0);
    gm.f(1.0f);
    gm.f('c');
    gm.f(gm);

    List<String> ls = makeList("A");
    System.out.println(ls);
    ls = makeList("A", "B", "C");
    System.out.println(ls);
    ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
    System.out.println(ls);
  }

}
