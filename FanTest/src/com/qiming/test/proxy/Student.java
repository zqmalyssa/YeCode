package com.qiming.test.proxy;

/**
 * 被代理的类
 */
public class Student implements Person{

  private String name;

  public Student(String name) {
    this.name = name;
  }

  @Override
  public void giveTask() {
    System.out.println(name + " 交语文作业");
  }
}
