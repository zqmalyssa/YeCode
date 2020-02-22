package com.qiming.algorithm;

/**
 * 反转一个链表，输出反转后的头结点
 * 思路就是用到三个指针，分别用到前一个，本身和后一个结点
 */
public class ReverseList {

  public static void main(String args[]) {
    SNode s1 = new SNode(1, null);
    SNode s2 = new SNode(2, s1);
    SNode s3 = new SNode(3, s2);
    SNode s4 = new SNode(4, s3);
    SNode s5 = new SNode(5, s4);
    SNode s6 = new SNode(6, s5);
    SNode s7 = new SNode(7, s6);

    SNode reversed = ReverseList(s7);
    SNode tmp = reversed;
    do {
      System.out.println(reversed.getVal());
      reversed = reversed.getNext();
    } while (reversed.getNext() != null);
    //最后再打印一次吧
    System.out.println(reversed.getVal());

    //这样不就在没有头结点的时候可以全部打印了吗。。。。。
    while(tmp != null) {
      System.out.println(tmp.getVal());
      tmp = tmp.getNext();
    }
  }

  private static SNode ReverseList(SNode head) {
    SNode pReversedHead = null;
    SNode pNode = head;
    SNode pPrev = null;

    while (pNode != null) {
      SNode pnext = pNode.getNext();
      if (pnext == null) {
        pReversedHead = pNode;
      }

      pNode.setNext(pPrev);
      pPrev = pNode;
      pNode = pnext;
    }

    return pReversedHead;
  }

}
