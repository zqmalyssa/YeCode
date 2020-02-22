package com.qiming.test.datastructureAndAlgorithm.linearlist;

import com.qiming.test.datastructureAndAlgorithm.common.Node;

/**
 * 双向链表节点定义
 */

public class DLNode implements Node {

  private Object element;

  private DLNode pre;

  private DLNode next;

  public DLNode() {
    this(null, null, null); //如果还有有参的构造函数，可以用这种写法，不然编译不过
  }

  public DLNode(Object ele, DLNode pre, DLNode next) {
    this.element = ele;
    this.pre = pre;
    this.next = next;
  }

  public DLNode getNext() {
    return next;
  }

  public void setNext(DLNode next) {
    this.next = next;
  }

  public DLNode getPre() {
    return pre;
  }

  public void setPre(DLNode pre) {
    this.pre = pre;
  }

  //下面是实现的方法
  public Object getData() {
    return element;
  }

  public void setData(Object obj) {
    this.element = obj;
  }
}
