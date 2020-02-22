package com.qiming.algorithm;


import com.qiming.test.datastructureAndAlgorithm.common.StackEmptyException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 倒序打印链表
 */
public class PrintLinkedList {

  public static void main(String args[]) {

    SNode s1 = new SNode(1, null);
    SNode s2 = new SNode(2, s1);
    SNode s3 = new SNode(3, s2);
    SNode s4 = new SNode(4, s3);
    SNode s5 = new SNode(5, s4);
    SNode s6 = new SNode(6, s5);
    SNode s7 = new SNode(7, s6);

    SNode head = new SNode(-1, s7);

//    while(head.getNext() != null) {
//      System.out.println(head.getNext().getVal());
//      head = head.getNext();
//    }

//    new PrintLinkedList().printReversingly(head);
    new PrintLinkedList().printReversinglyBySelfStack(head);

  }

  private void printReversingly(SNode head) {

    LinkedList<SNode> stack = new LinkedList();

    while(head.getNext() != null) {
      stack.push(head.getNext());
      head = head.getNext();
    }

    Iterator iterator = stack.iterator();
    while(iterator.hasNext()) {
      SNode s = (SNode)iterator.next();
      System.out.println(s.getVal());
    }

  }

  private void printReversinglyBySelfStack(SNode head) {

    Stack stack = new Stack();
    while(head.getNext() != null) {
      stack.push(head.getNext());
      head = head.getNext();
    }

    while(!stack.isEmpty()) {
      System.out.println(stack.pop().getVal());
    }

  }


}

/**
 * Node设计
 */
class SNode {

  private int val;
  private SNode next;

  public SNode(int val, SNode next){
    this.val = val;
    this.next = next;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public SNode getNext() {
    return next;
  }

  public void setNext(SNode next) {
    this.next = next;
  }
}

/**
 * 栈设计
 */
class Stack {
  private SNode top;
  private int size;

  public Stack() {
    this.top = null;
    this.size = 0;
  }

  public int getSize() {return size;};

  public boolean isEmpty() {return size == 0;};

  public void push(SNode node) {
    SNode p = new SNode(node.getVal(), top);
    top = p;
    size++;
  }

  public SNode pop() {
    if (size < 1) {
      throw new StackEmptyException("错误，堆栈为空。");
    }
    SNode result = top;
    top = top.getNext();
    size--;
    return result;
  }

  public SNode peek() {
    if (size < 1) {
      throw new StackEmptyException("错误，堆栈为空。");
    }
    return top;
  }
}