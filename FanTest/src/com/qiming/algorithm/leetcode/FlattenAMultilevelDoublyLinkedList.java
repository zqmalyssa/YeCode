package com.qiming.algorithm.leetcode;

/**
 * 扁平化多级双向链表
 *
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 *
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 * 思路 递归的思路，注意判空跟置child为空，细节细节
 *
 */
public class FlattenAMultilevelDoublyLinkedList {

  public static void main(String[] args) {
    NodeFlattenAMultilevelDoublyLinkedList node1 = new NodeFlattenAMultilevelDoublyLinkedList();
    node1.val = 1;
    NodeFlattenAMultilevelDoublyLinkedList node2 = new NodeFlattenAMultilevelDoublyLinkedList();
    node2.val = 2;
    NodeFlattenAMultilevelDoublyLinkedList node3 = new NodeFlattenAMultilevelDoublyLinkedList();
    node3.val = 3;
    NodeFlattenAMultilevelDoublyLinkedList node4 = new NodeFlattenAMultilevelDoublyLinkedList();
    node4.val = 4;
    NodeFlattenAMultilevelDoublyLinkedList node5 = new NodeFlattenAMultilevelDoublyLinkedList();
    node5.val = 5;
    NodeFlattenAMultilevelDoublyLinkedList node6 = new NodeFlattenAMultilevelDoublyLinkedList();
    node6.val = 6;
    NodeFlattenAMultilevelDoublyLinkedList node7 = new NodeFlattenAMultilevelDoublyLinkedList();
    node7.val = 7;
    NodeFlattenAMultilevelDoublyLinkedList node8 = new NodeFlattenAMultilevelDoublyLinkedList();
    node8.val = 8;
    NodeFlattenAMultilevelDoublyLinkedList node9 = new NodeFlattenAMultilevelDoublyLinkedList();
    node9.val = 9;
    NodeFlattenAMultilevelDoublyLinkedList node10 = new NodeFlattenAMultilevelDoublyLinkedList();
    node10.val = 10;
    NodeFlattenAMultilevelDoublyLinkedList node11 = new NodeFlattenAMultilevelDoublyLinkedList();
    node11.val = 11;
    NodeFlattenAMultilevelDoublyLinkedList node12 = new NodeFlattenAMultilevelDoublyLinkedList();
    node12.val = 12;

    node1.next = node2;
    node2.prev = node1;
    node2.next = node3;
    node3.prev = node2;
    node3.next = node4;
    node3.child = node7;
    node4.prev = node3;
    node4.next = node5;
    node5.prev = node4;
    node5.next = node6;
    node6.prev = node5;
    node6.next = null;
    node7.next = node8;
    node8.prev = node7;
    node8.next = node9;
    node8.child = node11;
    node9.prev = node8;
    node9.next = node10;
    node10.prev = node9;
    node10.next = null;
    node11.next = node12;
    node12.prev = node11;
    node12.next =null;

    NodeFlattenAMultilevelDoublyLinkedList result = new FlattenAMultilevelDoublyLinkedList().flatten(node1);
    System.out.println("end");
  }

  public NodeFlattenAMultilevelDoublyLinkedList flatten(NodeFlattenAMultilevelDoublyLinkedList head) {
    NodeFlattenAMultilevelDoublyLinkedList p = head;
    while (p != null && p.child == null) {
      p = p.next;
    }
    if (p != null) {
      //说明有child
      NodeFlattenAMultilevelDoublyLinkedList next = p.next;
      p.next = p.child;
      p.child.prev = p;
      NodeFlattenAMultilevelDoublyLinkedList nextLevel = p.child;
      while (nextLevel.next != null) {
        nextLevel = nextLevel.next;
      }
      nextLevel.next = next;
      //nullpoint，有一种特殊的情况考虑，即每一层都只有一个节点，又都有孩子，这时候next就是null了
//      next.prev = nextLevel;
      if (next != null) {
        next.prev = nextLevel;
      }
      flatten(p.child);
      //要置空哦
      p.child = null;
    } else {
      return head;
    }
    return head;
  }

}

class NodeFlattenAMultilevelDoublyLinkedList {
  public int val;
  public NodeFlattenAMultilevelDoublyLinkedList prev;
  public NodeFlattenAMultilevelDoublyLinkedList next;
  public NodeFlattenAMultilevelDoublyLinkedList child;
}