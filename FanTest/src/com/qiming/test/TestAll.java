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
    ((LinkedList<Character>) listChar).poll();
//    listChar.add('a');
//    listChar.add('b');
//    Character[] char1 = (Character[])listChar.toArray();
//    System.out.println(String.valueOf(char1));
//    System.out.println(listChar.toString());

    TreeSet set = new TreeSet();
    set.add(2);
    set.add(7);
    set.add(5);

    for (Object o : set) {
      System.out.println((int)o);
    }


    LinkedHashMap<Integer, String> lhm = new LinkedHashMap();
    lhm.put(2, "2");
    lhm.put(7, "7");
    lhm.put(5, "5");

    for (Integer o : lhm.keySet()) {
      System.out.println(lhm.get(o));
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(i);
      if (i == 1) {
        i = 4;
        continue;
      }

    }

    StringBuilder sb = new StringBuilder();
    sb.append("");

    sb.append("");
    sb.append("m");

    System.out.println(sb.toString());

    System.out.println(returnInt());


    String str = "1,3,4,null,5,";

    String []array = str.split(",");

    System.out.println(array.length);

    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }

    System.out.println('4' - 48);


  }

  private static void change(int a) {
    a = a + 1;
  }


  private static int returnInt() {

    int x = 100;

    try {
      x = 200;
      return x;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      x = 300;
      return x;
    }

  }


}
