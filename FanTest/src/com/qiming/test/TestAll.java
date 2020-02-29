package com.qiming.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestAll {

  public static void main(String[] args) {

//    int a = 2;
//    int b = 3;
//    System.out.println(a & b);
//    HashMap map = new HashMap();
//
//    String abc = "abcabcabcabcabc";
//    System.out.println(abc.hashCode());
//
//    List<String> list = Arrays.asList("a b c d e f".split(" "));
//    Collections.binarySearch(list, "c");
//
//    ArrayList list1 = new ArrayList();
//    list1.remove(a);
//    list1.indexOf(a);
//    TreeSet set = new TreeSet<>();
//    list1.contains(a);
//    set.contains(a);
//    HashSet set2 = new HashSet();
//    set2.contains(a);
//    set2.add(b);
//
//    LinkedList list2 = new LinkedList();
//    list2.contains(a);
//    list2.indexOf(a);
//
//
//    TreeMap map1 = new TreeMap();
//    HashMap map2 = new HashMap();

    List<Character> listChar = new LinkedList<>();
    listChar.add('a');
    listChar.add('b');
    Character[] char1 = (Character[])listChar.toArray();
    System.out.println(String.valueOf(char1));
    System.out.println(listChar.toString());


  }

  private static void change(int a) {
    a = a + 1;
  }



}
