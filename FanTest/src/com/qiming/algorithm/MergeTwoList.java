package com.qiming.algorithm;

/**
 * 前提是两个有序的链表，合并之后还是有序的
 * 比较两个链表的第一个元素，但是要做到鲁棒，记得null的判断，使用递归写
 */
public class MergeTwoList {

  public static void main(String args[]) {
    SNode s1 = new SNode(8, null);
    SNode s2 = new SNode(6, s1);
//    SNode s2 = new SNode(7, s1);
    SNode s3 = new SNode(4, s2);
    SNode s4 = new SNode(2, s3);

    SNode s5 = new SNode(7, null);
    SNode s6 = new SNode(5, s5);
    SNode s7 = new SNode(3, s6);
//    SNode s7 = new SNode(2, s6);
    SNode s8 = new SNode(1, s7);

//    SNode newHead = mergeTwoList(s4, s8);

    SNode newHead = mergeTwoListByIteration(s4, s8);
    while(newHead != null) {
      System.out.println(newHead.getVal());
      newHead = newHead.getNext();
    }

  }

  private static SNode mergeTwoList(SNode head1, SNode head2) {
    //判断空情况
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    SNode newHead;
    if (head1.getVal() < head2.getVal()) {
      newHead = head1;
      newHead.setNext(mergeTwoList(head1.getNext(), head2));
    } else {
      newHead = head2;
      newHead.setNext(mergeTwoList(head1, head2.getNext()));
    }
    return newHead;
  }

  private static SNode mergeTwoListByIteration(SNode head1, SNode head2) {
    //判断空情况
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    SNode head = new SNode(-1, null);
    SNode result = head;

    //这边是且
    while (head1 != null && head2 != null) {
      //其实这边用个等于号就行
      if (head1.getVal() >= head2.getVal()) {
        head.setNext(head2);
        head = head.getNext();
        head2 = head2.getNext();
      } else if (head1.getVal() < head2.getVal()) {
        head.setNext(head1);
        head = head.getNext();
        head1 = head1.getNext();
      }
//      } else {
//        SNode s1 = new SNode(head1.getVal(), null);
//        SNode s2 = new SNode(head1.getVal(), null);
//        head.setNext(s1);
//        head = head.getNext();
//        head.setNext(s2);
//        head = head.getNext();
////        这样写会有问题，1,2步后 head和head1指针就相同了，如果head.setNext(head2);后就会导致head1也发生变化，重复数据用上面的方法搞吧
////        head.setNext(head1);
////        head = head.getNext();
////        head.setNext(head2);
////        head = head.getNext();
//        head1 = head1.getNext();
//        head2 = head2.getNext();
//      }
    }

    //要进行补充
    if (head1 != null) {
      head.setNext(head1);
    }

    if (head2 != null) {
      head.setNext(head2);
    }

    return result.getNext();

  }

}
