package com.qiming.test;

//想这个类不被实例化，显示写个构造器
public class UtilityClass {

  private UtilityClass() {
    throw new AssertionError();
  }

}
