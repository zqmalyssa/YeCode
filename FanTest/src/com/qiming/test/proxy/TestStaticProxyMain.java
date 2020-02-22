package com.qiming.test.proxy;

public class TestStaticProxyMain {

  public static void main(String[] args) {

    //被代理的学生强哥，他的作业上交有代理对象monitor完成
    Person qiangge = new Student("强哥");

    //生成代理对象，并将林浅传给代理对象
    Person monitor = new StudentsProxy(qiangge);

    //班长代理交作业
    monitor.giveTask();

  }

}
