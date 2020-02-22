package com.qiming;

public class FatherClass {

  int a;
  int b;

  public FatherClass() {
    System.out.println("我是父类的无参构造");
    a = 10;
  }
  public FatherClass(int b) {
    System.out.println("我是父类的有参构造");
    this.b = b;
  }

  public void getClassName(){
    System.out.println("我是FatherClass");
  }

}
