package com.qiming.test.string;

/**
 * String引用的比较
 *
 *
 */
public class TestString {

  public static void main(String[] args) {
    String a= "abc";
    String b = "abc";
    String c = new String("abc");
    String d = "ab" + "c";

    System.out.println(a==b); //常量池
    System.out.println(a==c); //c不是常量池，是对象了
    System.out.println(a==d); //还是常量池
    System.out.println(c==d);

  }

}
