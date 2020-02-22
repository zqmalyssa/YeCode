package com.qiming.algorithm;

/**
 * 找到链表中倒数第K个结点
 * 让第一个指针先走k-1步，第二个指指针跟其始终保持这个距离即可
 */
public class LastKNode {

  public static void main(String args[]) {
    SNode s1 = new SNode(1, null);
    SNode s2 = new SNode(2, s1);
    SNode s3 = new SNode(3, s2);
    SNode s4 = new SNode(4, s3);
    SNode s5 = new SNode(5, s4);
    SNode s6 = new SNode(6, s5);
    SNode s7 = new SNode(7, s6);

    System.out.println(findLastKNode(s7, 3).getVal());
  }

  private static SNode findLastKNode(SNode head, int k) {
    if (head == null || k == 0) {
      return null;
    }
    SNode first = head, second = head;
    for (int i = 0; i < k-1; ++i) {
      if (first.getNext() != null) {
        first = first.getNext();
      } else {
        return null;
      }
    }
    while (first.getNext() != null) {
      first = first.getNext();
      second = second.getNext();
    }
    return second;
  }

}
