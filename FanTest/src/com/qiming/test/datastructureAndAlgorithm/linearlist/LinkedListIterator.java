package com.qiming.test.datastructureAndAlgorithm.linearlist;

import com.qiming.test.datastructureAndAlgorithm.common.Iterator;
import com.qiming.test.datastructureAndAlgorithm.common.Node;
import com.qiming.test.datastructureAndAlgorithm.common.OutOfBoundaryException;

public class LinkedListIterator implements Iterator {

  private LinkedList list;
  private Node current;

  public LinkedListIterator(LinkedList list) {
    this.list = list;
    if (list.isEmpty()) {
      current = null;
    } else {
      current = list.first();
    }
  }

  public void first() {
    if (list.isEmpty()) {
      current = null;
    } else {
      current = list.first();
    }
  }

  public void next() throws OutOfBoundaryException {
    if (isDone()) {
      throw new OutOfBoundaryException("错误：已经没有元素。");
    }
    if (current == list.last()) {
      current = null;
    } else {
      current = list.getNext(current);
    }
  }

  public boolean isDone() {
    return current == null;
  }

  public Object currentItem() throws OutOfBoundaryException{
    if (isDone()) {
      throw new OutOfBoundaryException("错误：已经没有元素。");
    }
    return current.getData();
  }

}
