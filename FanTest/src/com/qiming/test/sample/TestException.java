package com.qiming.test.sample;

import java.util.HashMap;

public class TestException {

  public static void main(String args[]) {
    HashMap map = new HashMap();
    map.put(1,3);
    System.out.println(map.get(1));
//    throw new RuntimeException("nihao");
  }

}
