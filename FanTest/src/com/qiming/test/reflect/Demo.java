package com.qiming.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {

  public static void main(String args[]) {
    //1.类名.class

    Class clz = User.class;
    System.out.println(clz);

    //2.对象名.getClass()

    Class clz1 = new User().getClass();
    System.out.println(clz==clz1);

    //3.Class.forName()

    //Class clz2 = Class.forName("User");
    Class clz2 = null;

    Object obj = null;
    try {
      clz2 = Class.forName("com.qiming.test.reflect.User");
      obj = clz2.newInstance();
      System.out.println(obj);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    System.out.println(clz==clz2);


    User u1 = new User("张三", 10);
    User u2 = new User("李四", 20);

    try {
      Method m1 = clz2.getMethod("exit");
      Object obj1 = m1.invoke(u2);
      System.out.println(obj1); //Object输出为null，因为方法返回值是null
      Method m2 = clz2.getMethod("login", String.class, String.class);
      Object obj2 = m2.invoke(u2, "赵五", "1234");
      System.out.println(obj2); //Object输出为null，因为方法返回值是null
      //暴力获取私有方法
      Method m3 = clz2.getDeclaredMethod("CheckInfo");
      //修改了访问控制级别，因为类中是private修饰
      m3.setAccessible(true);
      Object obj3 = m3.invoke(u1);
      System.out.println(obj3); //Object输出有值，因为有返回值

      Object newInstance = clz2.newInstance();
      Field f1 = clz2.getField("name");
      f1.set(newInstance, "钱六");
      Object obj4 = f1.get(newInstance);  //这个object是什么呢，输出就是 钱六
      System.out.println(obj4);
      System.out.println(newInstance); //这是User对象

      User test = new User("王八", 40);
      Field f2 = clz2.getDeclaredField("age");
      f2.setAccessible(true);
      Object obj5 = f2.get(test);
      System.out.println(obj5);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
  }

}
