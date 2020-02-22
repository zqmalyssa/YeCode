package com.qiming;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TestAll {

  public TestAll(int a, String name) {
    this.age = a;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private int age;
  private String name;

  public static void main(String[] args) {

    String s = "abcdefg";

    System.out.println(s.substring(0, s.length()));


//    Set set = new TreeSet();
//    Scanner scanner = new Scanner(System.in);
//    int num = scanner.nextInt();
//    for (int i = 0; i < num; i++) {
//      set.add(scanner.nextInt());
//    }
//    Iterator iterator = set.iterator();
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
//    }


//    final TestAll ta = new TestAll(2, "nihao");
//
//    System.out.println(ta.name);
//    ta.setName("zaijian");
//    System.out.println(ta.name);
//
//    String s1 = "123";
//    String s2 = new String("123");
//
//    System.out.println(s1 == s2);
//    System.out.println(s1.equals(s2));
////    for (int i = 0,j = 0;i < 10;i++){
////      System.out.println(i);
////      System.out.println(j);
////    }
//    /**
//     * 加入泛型后
//     */
//    LinkedHashMap<Integer, String> map = new LinkedHashMap();
//    map.put(1, "123");
//    String s = map.get(1);


//    System.out.println(s + " " + x);
//
//    for (int i = 0; i < list.size(); i++) {
//      System.out.println(list.get(i));
//    }


  }


  private static String[] handle(String str) {
    if (str == null || str.equals("")) {
      return null;
    }

    char[] chars = str.toCharArray();
    if (chars.length % 8 == 0) {
      int arraynum = chars.length / 8;
      String[] s = new String[arraynum];
      for (int i = 0; i < arraynum; i++) {
        char[] temp = new char[8];
        for (int j = 0 ; j < temp.length; j++) {
          temp[j] = chars[i*8+j];
        }
        s[i] = temp.toString();
      }
      return s;
    } else {
      int arraynum = chars.length / 8 + 1;
      int havenum = chars.length % 8;
      String[] s = new String[arraynum];
      for (int i = 0; i < arraynum - 1; i++) {
        char[] temp = new char[8];
        for (int j = 0 ; j < temp.length; j++) {
          temp[j] = chars[i*8+j];
        }
        s[i] = temp.toString();
      }
      char[] last = new char[8];;
      for (int i = 0; i < havenum; i++) {
        last[i] = chars[(arraynum-1) * 8 + i];
      }
      for (int j = 7; j > havenum - 1; j--) {
        last[j] = '0';
      }
      //再补充最后的
      s[arraynum-1] = last.toString();
      return s;
    }
  }


}
