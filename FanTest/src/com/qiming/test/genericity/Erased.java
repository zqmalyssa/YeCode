package com.qiming.test.genericity;

import java.util.ArrayList;

/**
 * 泛型擦除
 */
public class Erased {

  public static void main(String[] args) {
    //很容易以为着是两个不同的class
    Class c1 = new ArrayList<String>().getClass();
    Class c2 = new ArrayList<Integer>().getClass();
    System.out.println(c1 == c2);
  }

}
