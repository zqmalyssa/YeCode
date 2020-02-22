package com.qiming.test.variantorinvariant;

import java.util.ArrayList;
import java.util.List;

/**
 * addAll()方法复制，看清楚，是复制的，不是直接给的，是被添加列表的元素引用，本质上是只复制了元素的引用，并没有复制元素本身，要深刻理解这一点。
 *
 * 以调用L1.addAll(L2)为例，当列表里元素为不可变元素（例如String）类型时，对L2列表内元素进行更改不会影响到L1，因为String类型本身并不能被修改，对元素的修改本质上都是修该元素引用，而引用是互不影响的。
 *
 * 如果列表内元素为可变元素（例如List、Map）类型，对列表L2内引用的元素的修改是会影响到L1的，因为只复制了引用，而引用指向的是同样的元素。
 */
public class TestVar {

  public static void main(String[] args) {
    List<String> l1 = new ArrayList<String>();// l1为内部存储String类型的列表
    l1.add("1-1");
    l1.add("1-2");
    l1.add("1-3");
    l1.add("1-4");
    l1.add("1-5");
    List<List<String>> l2 = new ArrayList<List<String>>();// l2为内部存储ArrayList类型的列表
    List<String> l_t1 = new ArrayList<String>();
    l_t1.add("l_t1_1");
    List<String> l_t2 = new ArrayList<String>();
    l_t2.add("l_t1_2");
    List<String> l_t3 = new ArrayList<String>();
    l_t3.add("l_t1_3");
    l2.add(l_t1);
    l2.add(l_t2);
    l2.add(l_t3);

    List<String> l3 = new ArrayList<String>();// 创建空l3列表
    l3.addAll(l1);// l3列表内添加l1列表
    l1.set(3, "test");// 修改l1列表内元素的引用
    System.out.println("l1---" + l1);
    System.out.println("l3---" + l3);// 二者互不影响,String是不可变元素

    List<List<String>> l4 = new ArrayList<List<String>>();// 创建空l4列表
    l4.addAll(l2);// l4列表内添加l2列表
    l2.get(1).set(0, "update");
    l2.get(1).add("add");// 对l2列表内的元素进行修改，影响到了l4
    System.out.println("l2---" + l2);
    System.out.println("l4---" + l4);

    List<String> l_t = new ArrayList<String>();
    l_t.add("test");
    l2.set(1, l_t);// 对l2列表内元素的引用进行修改，这个相当于是修改了引用，l4不受影响
    System.out.println("l2---" + l2);
    System.out.println("l4---" + l4);// 如果修改l2列表内元素，互相影响，如果修改l2列表内元素的引用，互不影响。

  }

}
