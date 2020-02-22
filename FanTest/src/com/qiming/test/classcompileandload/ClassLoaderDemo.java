package com.qiming.test.classcompileandload;

/**
 * 看JDK中的ClassLoader的继承关系
 *
 * 可以看见System后Extension，但是没有Bootstrap，因为它并不是Java中的ClassLoader
 */
public class ClassLoaderDemo {

  public static void main(String[] args) {

    System.out.println(ClassLoaderDemo.class.getClassLoader());
    System.out.println(ClassLoaderDemo.class.getClassLoader().getParent());
    System.out.println(ClassLoaderDemo.class.getClassLoader().getParent().getParent());


  }

}
