package com.qiming.test.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CGlibMain {

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(CGlibSubject.class);
    enhancer.setCallback(new CGlibInterceptor());
    CGlibSubject cGsubject = (CGlibSubject) enhancer.create();
    cGsubject.sayHello();
  }

}
