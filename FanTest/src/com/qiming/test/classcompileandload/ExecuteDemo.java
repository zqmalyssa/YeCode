package com.qiming.test.classcompileandload;

/**
 * 看JVM如何调用方法
 *
 * javac ExecuteDemo.java
 *
 * javap -c ExecuteDemo查看字节码
 *
 */
public class ExecuteDemo {

  public void execute() {
    A.execute();
    A a = new A();
    a.bar();
    IFoo b = new B();
    b.bar();
  }
}

class A {
  public static int execute() {
    return 1 + 2;
  }

  public int bar() {
    return 1 + 2;
  }
}

class B implements IFoo{
  public int bar() {
    return 1 + 2;
  }
}

interface IFoo {
  public int bar();
}
