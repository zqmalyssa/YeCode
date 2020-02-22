package com.qiming.test.genericity;

/**
 * 使用自限定类型，方法参数类型会随着子类而变化
 * @param <T>
 */
class GenericGetter<T extends GenericGetter<T>>{
  T element;
  void set(T element) { this.element = element; }
  T get() { return element; }
}

class Getter extends GenericGetter<Getter>{
}

public class GenericAndReturnTypes {
  static void test(Getter g) {
    Getter result = g.get();
    GenericGetter genericGetter = g.get();
  }

  public static void main(String[] args) {
    Getter getter = new Getter();
    test(getter);
  }
}
