package com.qiming.test.genericity;

public class HasF {

  public static void main(String[] args) {
    HasF hf = new HasF();
    Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
//    manipulator.manipulator();

  }

  public void f() {
    System.out.println("Hasf.f()");
  }

}

/**
 * Java编译器无法将manipulator()必须能够在obj上调用f()这一需求映射到HasF拥有f()这一事实上
 * 为了调用f()，我们必须协助泛型类，给定泛型类的边界，以此告知编译器只能接受遵循这个边界的类型！！这里就要用到extends
 * @param <T>
 */
class Manipulator<T> {
  private T obj;

  public Manipulator(T obj) {
    this.obj = obj;
  }
//
//  public void manipulator() {
//    obj.f();
//  }
}

/**
 * 这是修改后的，编译器就不报错了
 * @param <T>
 */
class Manipulator2<T extends HasF> {
  private T obj;

  public Manipulator2(T obj) {
    this.obj = obj;
  }

  public void manipulator() {
    obj.f();
  }
}