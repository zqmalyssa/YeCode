package com.qiming.algorithm;

/**
 * 删除链表的节点O(1)
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。主要是要求时间复杂度在O(1)
 *
 * 思路：核心思想就是将待删除结点的下一个结点的值赋给待删除结点，再更新next，注意边界一个是尾结点要遍历，一个是只有一个结点要删除
 *
 */
public class DeleteNode {

  public ListNodeDeleteNode deleteNode(ListNodeDeleteNode head, ListNodeDeleteNode val) {

    if (head == null || val == null) {
      return null;
    }

    if (val.next != null) {
      //待删除的结点不是尾结点
      ListNodeDeleteNode next = val.next;
      val.val = next.val;
      val.next = next.next;
    } else if (head == val) {
      //待删除的只有一个结点，且就是头结点
      head = null;
    } else {
      //待删除的是尾结点，需要遍历
      ListNodeDeleteNode cur = head;
      while (cur.next != val) {
        cur = cur.next;
      }
      cur.next = null;
    }

    return head;
  }

}



class ListNodeDeleteNode {
  int val;
  ListNodeDeleteNode next;
  ListNodeDeleteNode(int x) { val = x; }
}