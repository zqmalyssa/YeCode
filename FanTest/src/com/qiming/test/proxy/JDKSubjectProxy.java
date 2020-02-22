package com.qiming.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKSubjectProxy implements InvocationHandler {

  private JDKSubject jdkSubject;

  public JDKSubjectProxy(JDKSubject jdkSubject) {
    this.jdkSubject = jdkSubject;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("--------------begin-------------");
    Object invoke = method.invoke(jdkSubject, args);  //利用反射调用类里面的实际方法，method是那个方法，invoke是方法的返回值
    System.out.println("--------------end-------------");
    return invoke;
  }
}
