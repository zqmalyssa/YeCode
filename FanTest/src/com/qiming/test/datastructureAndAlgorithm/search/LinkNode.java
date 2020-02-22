package com.qiming.test.datastructureAndAlgorithm.search;

public class LinkNode {

  private int val;
  private LinkNode next;

  LinkNode(int val) {
    this.val = val;
  }

  public static void main(String args[]) {
    LinkNode head = new LinkNode(0);
    LinkNode data1 = new LinkNode(4);
    LinkNode data2 = new LinkNode(5);
    LinkNode data3 = new LinkNode(6);
    head.next = data1;
    data1.next = data2;
    data2.next = data3;

    while (head.next != null) {
      System.out.println(head.next.val);
      head = head.next;
    }
  }

}
