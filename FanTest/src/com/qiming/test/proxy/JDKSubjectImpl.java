package com.qiming.test.proxy;

public class JDKSubjectImpl implements JDKSubject{

  public void hello(String val) {
    System.out.println("hello" + val);
  }
}
