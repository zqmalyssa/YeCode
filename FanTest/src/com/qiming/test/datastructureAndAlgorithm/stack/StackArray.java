package com.qiming.test.datastructureAndAlgorithm.stack;

import com.qiming.test.datastructureAndAlgorithm.common.StackEmptyException;

/**
 * 栈的顺序存储实现
 */
public class StackArray implements Stack{

  private final int LEN = 8;
  private Object[] elements;
  private int top;

  public StackArray() {
    top = -1;
    elements = new Object[LEN];
  }

  public int getSize() {
    return top + 1;
  }

  public boolean isEmpty() {
    return top < 0;
  }

  public void push(Object e) {
    if (getSize() >= elements.length){
      expandSpace();
    }
    elements[++top] = e;
  }

  public Object pop() throws StackEmptyException {
    if (getSize() < 1) {
      throw new StackEmptyException("错误，堆栈为空。");
    }
    //这样做，防止内存泄漏，不要直接return elements[top]，栈内部的数组还保留着这个引用。
    Object obj = elements[top];
    elements[top--] = null;
    return obj;
  }

  //取元素，但不出栈
  public Object peek() throws StackEmptyException {
    if (getSize() < 1) {
      throw new StackEmptyException("错误，堆栈为空。");
    }
    return elements[top];
  }

  //扩展容量
  private void expandSpace() {
    Object[] a = new Object[elements.length*2];
    for (int i = 0; i < elements.length; i++) {
      a[i] = elements[i];
    }
    elements = a;
  }
}
