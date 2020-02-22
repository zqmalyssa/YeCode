package com.qiming.test.datastructureAndAlgorithm.linearlist;

import com.qiming.test.datastructureAndAlgorithm.common.Node;

public class SLNode implements Node {

  private Object element;
  private SLNode next;

  public SLNode() {
    this(null, null);
  }

  public SLNode(Object ele, SLNode next) {
    this.element = ele;
    this.next = next;
  }

  public SLNode getNext() {
    return next;
  }

  public void setNext(SLNode next) {
    this.next = next;
  }


  //实现的方法
  public Object getData() {
    return element;
  }

  public void setData(Object obj) {
    element = obj;
  }
}
