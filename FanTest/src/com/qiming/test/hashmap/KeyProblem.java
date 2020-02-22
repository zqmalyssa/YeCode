package com.qiming.test.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 当HashMap中的key是可变时候会出现的问题
 *
 */
public class KeyProblem {

  public static void main(String[] args) {

    HashMap<List<String>, Object> changeMap = new HashMap();

    List<String> list = new ArrayList<>();

    list.add("hello");

    Object obj = new Object();

    changeMap.put(list, obj);

    System.out.println(changeMap.get(list));
    System.out.println(list.hashCode());

    list.add("World"); // list的hashcode发生了改变

    System.out.println(changeMap.get(list));
    System.out.println(list.hashCode());
  }

}
