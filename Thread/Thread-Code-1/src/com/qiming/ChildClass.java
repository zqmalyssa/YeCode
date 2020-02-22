package com.qiming;

public class ChildClass extends FatherClass{

  public ChildClass() {
//      System.out.println("我是子类的无参构造");
    //super必须写在第一行
//      super(3);
    b = 2;
  }

  public ChildClass(int b) {
    super(b);
  }

  public static void main(String[] args) {
    ChildClass t = new ChildClass(10);
    ChildClass t1 = new ChildClass();
    System.out.println(t.a);
    System.out.println(t.b);
    System.out.println(t1.a);
    System.out.println(t1.b);
  }
  @Override
  public void getClassName(){
    System.out.println("我是ChildClass");
  }

}
