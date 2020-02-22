package com.qiming.HW;

import java.util.Scanner;

public class FindNum {

  public static void main(String args[]) {

    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
      int m = in.nextInt();
      if (m <= 1 || m >= 100) {
        System.out.println("ERROR!");
        continue;
      }
      //构建一个循序链表，从1到100
      SNode head = new SNode(1, null);
      SNode start = head;
      for (int i = 2; i <= 100; i++) {
        SNode p = new SNode(i, null);
        head.setNext(p);
        head = head.getNext();
      }
      head.setNext(start);

      SNode newHead = findnum(m, start);
      //打印输出
      StringBuilder sb = new StringBuilder();
      int statrVal = newHead.getVal();
      sb.append(statrVal).append(",");
      while(newHead.getNext().getVal() != statrVal) {
        sb.append(newHead.getNext().getVal()).append(",");
        newHead = newHead.getNext();
      }
      System.out.println(sb.substring(0, sb.length() - 1));
    }
  }

  private static SNode findnum(int m, SNode head) {
    int count = 0;
    int leavePerson = 100 - m + 1;
    SNode tmp = head;
    while (count < leavePerson) {
      for (int i = 0; i < m - 1; i++) {
        head = head.getNext();
      }
      for (int i = 0; i < m - 2; i++) {
        tmp = tmp.getNext();
      }
      //断开链表中的结点
      tmp.setNext(head.getNext());
      SNode tmp2 = head.getNext();
      head = tmp2;
      tmp = tmp2;
      count++;
    }
    return head;
  }

}


class SNode {

  private int val;
  private SNode next;

  public SNode (int val, SNode next) {
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