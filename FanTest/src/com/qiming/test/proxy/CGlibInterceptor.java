package com.qiming.test.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibInterceptor implements MethodInterceptor {

  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    //d是被代理对象的实例，methodProxy是代理方法
    System.out.println("begin time -----> "+ System.currentTimeMillis());
    Object o1 = methodProxy.invokeSuper(o, objects);  //调用被拦截的方法，不要使用invoke，会出现OOM的情况
    System.out.println("end time -----> "+ System.currentTimeMillis());
    return o1;
  }
}
