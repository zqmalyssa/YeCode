package com.qiming.test.datastructureAndAlgorithm.linearlist;

import com.qiming.test.datastructureAndAlgorithm.common.InvalidNodeException;
import com.qiming.test.datastructureAndAlgorithm.common.Iterator;
import com.qiming.test.datastructureAndAlgorithm.common.Node;
import com.qiming.test.datastructureAndAlgorithm.common.OutOfBoundaryException;

public class LinkedListDLNode implements LinkedList {

  private int size;
  private DLNode head;  //头结点，哑元结点
  private DLNode tail;  //尾结点，哑元结点

  public LinkedListDLNode() {
    size = 0;
    head = new DLNode();
    tail = new DLNode();
    head.setNext(tail);
    tail.setPre(head);
  }

  protected DLNode checkPosition(Node p) throws InvalidNodeException {
    if (p == null) {
      throw new InvalidNodeException("错误: p为空");
    }
    if (p == head) {
      throw new InvalidNodeException("错误: p指向头结点，非法");
    }
    if (p == tail) {
      throw new InvalidNodeException("错误: p指向尾结点，非法");
    }
    DLNode node = (DLNode)p;
    return node;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Node first() throws OutOfBoundaryException {
    if (isEmpty()) {
      throw new OutOfBoundaryException("错误: 链接表为空");
    }
    return head.getNext();
  }

  public Node last() throws OutOfBoundaryException {
    if (isEmpty()) {
      throw new OutOfBoundaryException("错误: 链接表为空");
    }
    return tail.getPre();
  }

  public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {
    DLNode node = checkPosition(p);
    node = node.getNext();
    if (node == tail) {
      throw new OutOfBoundaryException("错误：已经是链接表尾端");
    }
    return node;
  }

  public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {
    DLNode node = checkPosition(p);
    node = node.getPre();
    if (node == head) {
      throw new OutOfBoundaryException("错误：已经是链接表前端");
    }
    return node;
  }

  public Node insertFirst(Object e) {
    DLNode node = new DLNode(e, head, head.getNext());
    head.getNext().setPre(node);
    head.setNext(node);
    size++;
    return node;
  }

  public Node insertLast(Object e) {
    DLNode node = new DLNode(e, tail.getPre(), tail);
    tail.getPre().setNext(node);
    tail.setPre(node);
    size++;
    return node;
  }

  public Node insertAfter(Node p, Object e) throws InvalidNodeException {
    DLNode node = checkPosition(p);
    DLNode newNode = new DLNode(e, node, node.getNext());
    node.getNext().setPre(newNode);
    node.setNext(newNode);
    size++;
    return newNode;
  }

  public Node insertBefore(Node p, Object e) throws InvalidNodeException {
    DLNode node = checkPosition(p);
    DLNode newNode = new DLNode(e, node.getPre(), node);
    node.getPre().setNext(newNode);
    node.setPre(newNode);
    size++;
    return newNode;
  }

  public Object remove(Node p) throws InvalidNodeException {
    DLNode node = checkPosition(p);
    Object obj = node.getData();
    node.getPre().setNext(node.getNext());
    node.getNext().setPre(node.getPre());
    size--;
    return obj;
  }

  public Object removeFirst() throws OutOfBoundaryException {
    return remove(head.getNext());
  }

  public Object removeLast() throws OutOfBoundaryException {
    return remove(tail.getPre());
  }

  public Object replace(Node p, Object e) throws InvalidNodeException {
    DLNode node = checkPosition(p);
    Object obj = node.getData();
    node.setData(e);
    return obj;
  }

  public Iterator elements() {
    return new LinkedListIterator(this);
  }
}
