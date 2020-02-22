package com.qiming.test.genericity;

/**
 * 类型擦除与多态的冲突和解决方法
 * @param <T>
 */
public class Pair<T> {

  private T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
