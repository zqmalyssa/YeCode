package com.qiming.algorithm;

/**
 * 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 思路：正常的先复制next再复制random需要O(n^2)，如果用辅助空间记录random的位置，则可以缩减到O(n)，如果不用辅助空间，就将复制的链表挨个结点的放到原链表后面，那么random
 * 其实就是原random位置的下一个位置了，再遍历得到之后的链表
 *
 */
public class CloneNodes {

  public static void main(String[] args) {



  }

  public NodeCloneNodes copyRandomList(NodeCloneNodes head) {

    if (head == null) return null;
    NodeCloneNodes p = head;
    while (p!=null) {
      NodeCloneNodes cur = p;
      p = p.next;
      NodeCloneNodes copy = copy(cur);
      cur.next = copy;
    }
    p = head;
    for (int i=0;p!=null;i++,p=p.next) {
      // 复制的节点
      if ((i&1) == 1) {
        if (p.random!=null) {
          p.random = p.random.next;
        }
      }
    }
    p = head;
    NodeCloneNodes newHead = p.next;
    //这边是断开了两组链表
    while (p!=null) {
      NodeCloneNodes cur = p;
      p = p.next;
      if (cur.next!=null) {
        cur.next = cur.next.next;
      }

    }
    return newHead;

  }

  private NodeCloneNodes copy(NodeCloneNodes node) {
    NodeCloneNodes newNode = new NodeCloneNodes(node.val);
    newNode.next = node.next;
    newNode.random = node.random;
    return newNode;
  }


}


class NodeCloneNodes {
  int val;
  NodeCloneNodes next;
  NodeCloneNodes random;

  public NodeCloneNodes(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}