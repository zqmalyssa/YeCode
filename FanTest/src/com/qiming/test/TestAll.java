package com.qiming.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class TestAll {

  public static void main(String[] args) {

    int a = 2;
    int b = 3;
    System.out.println(a & b);
    HashMap map = new HashMap();

    String abc = "abcabcabcabcabc";
    System.out.println(abc.hashCode());

    List<String> list = Arrays.asList("a b c d e f".split(" "));
    Collections.binarySearch(list, "c");


  }

  private static void change(int a) {
    a = a + 1;
  }



}
