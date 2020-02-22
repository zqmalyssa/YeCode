package com.qiming.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKMain {
  public static void main(String[] args) {
    JDKSubject subject = new JDKSubjectImpl();
    InvocationHandler subjectProxy = new JDKSubjectProxy(subject);
    JDKSubject proxyInstance = (JDKSubject) Proxy
        .newProxyInstance(subjectProxy.getClass().getClassLoader(), subject.getClass().getInterfaces(), subjectProxy);
    //第一个参数是代理类的类加载器，第二个参数是被代理类的接口，如果有多个就是数组形式传入，第三个参数是代理类实例
    proxyInstance.hello("world");
  }
}
