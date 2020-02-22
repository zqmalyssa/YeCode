package com.qiming.test.genericity;

public class ClassGen<T> {

  private T a;

  public ClassGen(T a) {
    this.a = a;
  }

  public T getA() {
    return a;
  }

  public void setA(T a) {
    this.a = a;
  }

  public static void main(String[] args) {
    ClassGen<User> test = new ClassGen<User>(new User());
    User user = test.getA();
    //下面这两处编译器就报错了
//    test.setA("设置成字符串");
//    test.setA(2);
  }
}
