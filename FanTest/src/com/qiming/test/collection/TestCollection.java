package com.qiming.test.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Collection接口下面继承的接口有Set，List，Queue
 */
public class TestCollection {

  public static void main(String args[]) {
    //Stack
    Stack stack = new Stack();

//    stack.push(1);
//    stack.push("3");
//
//    stack.pop();
//    stack.pop();

    Map map = new HashMap();

    Set set = new HashSet();

    Set treeSet = new TreeSet();

    treeSet.add(9);
    treeSet.add(6);
    treeSet.add(1);
    treeSet.add(2);
    treeSet.add(2);

    Iterator iterator =  treeSet.iterator();

    while (iterator.hasNext()) {
      Object s = iterator.next();
      System.out.println(s);
    }

  }

}
