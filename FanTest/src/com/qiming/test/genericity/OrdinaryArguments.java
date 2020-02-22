package com.qiming.test.genericity;

/**
 * 在非泛型的代码中，参数类型却不可以随子类变化而变化
 */
class Base{}
class Derived extends Base{}

class OrdinarySetter{
  void set(Base base) {
    System.out.println("OrdinarySetter.set(Base)");
  }
}

class DerivedSetter extends OrdinarySetter{
  //这个不算重写，而是重载
  void set(Derived derived) {
    System.out.println("DerivedSetter.set(Derived)");
  }
}

public class OrdinaryArguments {
  public static void main(String[] args) {
    Base base = new Base();
    Derived derived = new Derived();
    DerivedSetter ds = new DerivedSetter();

    //两个输出不一样
    ds.set(base);
    ds.set(derived);

  }
}
