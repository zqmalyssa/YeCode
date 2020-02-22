package com.qiming.algorithm.leetcode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 思路：用栈
 *
 */
public class PrintLinkedListReversal {

  public int[] reversePrint(ListNodePrintLinkedListReversal head) {

    Stack<Integer> stack = new Stack();
    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    int result[] = new int[stack.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = stack.pop();
    }
    return result;

  }

}

class ListNodePrintLinkedListReversal {
  int val;
  ListNodePrintLinkedListReversal next;
  ListNodePrintLinkedListReversal(int x) {val = x;}

}