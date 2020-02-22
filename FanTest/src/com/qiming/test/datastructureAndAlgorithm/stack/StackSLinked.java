package com.qiming.test.datastructureAndAlgorithm.stack;

import com.qiming.test.datastructureAndAlgorithm.common.StackEmptyException;
import com.qiming.test.datastructureAndAlgorithm.linearlist.SLNode;

public class StackSLinked implements Stack{

  private SLNode top;
  private int size;

  public StackSLinked() {
    top = null;
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(Object e) {
    SLNode q = new SLNode(e, top);
    top = q;
    size++;
  }

  public Object pop() throws StackEmptyException {
    if (size < 1) {
      throw new StackEmptyException("错误，堆栈为空。");
    }
    Object obj = top.getData();
    top = top.getNext();
    size--;
    return obj;
  }

  public Object peek() throws StackEmptyException {
    if (size < 1) {
      throw new StackEmptyException("错误，堆栈为空。");
    }
    return top.getData();
  }
}
