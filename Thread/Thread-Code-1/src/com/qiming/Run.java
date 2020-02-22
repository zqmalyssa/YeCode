package com.qiming;

public class Run {

  public static void main(String[] args){

    CountOperate c = new CountOperate();
//    c.start();
    Thread t1 = new Thread(c);
    System.out.println("main begin t1 isAlive=" + t1.isAlive());
    t1.setName("A");
    //是t1对象启动的线程，不是用c.start()直接启动，这就有说法了，有点绕的，将上面注释打开是不一样的
    //this代表的是CountOperate对象实例，所以this.getName()拿出来的是创建该对象实例后，调用的父类Thread的无参构造函数给定的名字
    t1.start();
    System.out.println("main end t1 isAlive=" + t1.isAlive());

  }

}
