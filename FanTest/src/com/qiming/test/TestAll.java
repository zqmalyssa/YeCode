package com.qiming.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TestAll {

  public static void main(String[] args) {

    int a = 2;
    int b = 3;
    System.out.println(a & b);
    HashMap map = new HashMap();

    String abc = "abcabcabcabcabc";
    System.out.println(abc.hashCode());


  }

  private static void change(int a) {
    a = a + 1;
  }



}
