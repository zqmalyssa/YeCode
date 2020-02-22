package com.qiming.test;

public class TestStaticFactory {

//  private TestStaticFactory(); //这样写是错误的，要么是public要么是protected

  public static TestStaticFactory newInstance(){
    return new TestStaticFactory();
  }

}
