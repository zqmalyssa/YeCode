package com.qiming.algorithm.leetcode;

/**
 * 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: 0->1->2->NULL, k = 4  输出: 2->0->1->NULL
 *
 * 解释: 向右旋转 1 步: 2->0->1->NULL  向右旋转 2 步: 1->2->0->NULL  向右旋转 3 步: 0->1->2->NULL  向右旋转 4 步: 2->0->1->NULL
 *
 * 思路 先算一遍长度，然后实际需要转的结点数是 k % size，之后就是细节和链表的一些基本操作
 */
public class RotateList {

  public static void main(String[] args) {
    ListNodeRotateList test1 = new ListNodeRotateList(0);
    ListNodeRotateList test2 = new ListNodeRotateList(1);
    ListNodeRotateList test3 = new ListNodeRotateList(2);
    test1.next = test2;
    test2.next = test3;
    test3.next =null;
    ListNodeRotateList result = new RotateList().rotateRight(test1, 4);

  }

  public ListNodeRotateList rotateRight(ListNodeRotateList head, int k) {
    ListNodeRotateList p = head;
    //算长度
    int size = 0;
    while (p != null) {
      size++;
      p = p.next;
    }
    if (size == 0) {
      return head;
    } else {
      int realTime = k % size;
      if (realTime == 0) {
        //不用变
        return head;
      } else {
        //变最后realTime个结点，移到前面即可
        ListNodeRotateList j = head;
        for (int i = 0; i < size - realTime - 1; i++) {
          j = j.next;
        }
        ListNodeRotateList newHead = j.next;
        //置为尾结点
        j.next = null;
        ListNodeRotateList tmp = newHead;
        for (int i = 0; i < realTime - 1; i++) {
          tmp = tmp.next;
        }
        tmp.next = head;
        return newHead;
      }
    }
  }

}


class ListNodeRotateList{
  int val;
  ListNodeRotateList next;
  ListNodeRotateList(int x) { val = x; }
}