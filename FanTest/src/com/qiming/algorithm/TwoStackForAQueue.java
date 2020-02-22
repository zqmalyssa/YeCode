package com.qiming.algorithm;

/**
 * 用两个栈实现一个队列，完成队列的appendTail和deleteHead方法
 * 第一个栈用来接刚插入的元素，只要有删除，只要stack2中有数据，就删一个栈顶元素，否则就从stack1中将数据弹入stack2
 */

import com.qiming.test.datastructureAndAlgorithm.common.StackEmptyException;

public class TwoStackForAQueue {

  //两个栈，要初始化
  private Stack stack1 = new Stack();
  private Stack stack2 = new Stack();

  public void appendTail(SNode s) {
    stack1.push(s);
  }

  public SNode deleteHead() {
    //删前先从stack1中搞过来
    if (stack2.getSize() <= 0) {
      while(stack1.getSize() > 0) {
        SNode p = stack1.peek();
        stack1.pop();
        stack2.push(p);
      }
    }
    //如果还是0的话
    if (stack2.getSize() == 0) {
      throw new StackEmptyException("Queue is empty");
    }

    //正常是有值得，进行删除
    SNode head = stack2.pop();
    return head;
  }

  public static void main(String args[]) {
    SNode s1 = new SNode(1, null);
    SNode s2 = new SNode(2, null);
    SNode s3 = new SNode(3, null);
    SNode s4 = new SNode(4, null);
    SNode s5 = new SNode(5, null);
    SNode s6 = new SNode(6, null);
    SNode s7 = new SNode(7, null);

    TwoStackForAQueue twoStackForAQueue = new TwoStackForAQueue();

    twoStackForAQueue.appendTail(s1);
    twoStackForAQueue.appendTail(s2);
    System.out.println(twoStackForAQueue.deleteHead().getVal());
    twoStackForAQueue.appendTail(s3);
    twoStackForAQueue.appendTail(s4);
    System.out.println(twoStackForAQueue.deleteHead().getVal());
    twoStackForAQueue.appendTail(s5);
    System.out.println(twoStackForAQueue.deleteHead().getVal());
    twoStackForAQueue.appendTail(s6);
    twoStackForAQueue.appendTail(s7);
    System.out.println(twoStackForAQueue.deleteHead().getVal());
  }

}


