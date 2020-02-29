package com.qiming.algorithm;

/**
 * 两个链表的第一个公共结点
 *
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 思路：蛮力不可取，用两个辅助栈呢，从尾部取出比较直到相同，可行，但是辅助空间又是O(m+n)了，用双指针，先走几步的方法
 *
 */
public class IntersectionOfTwoLinkedLists {

  public static void main(String[] args) {

    /**
     * LC这个跟OF测案例是不一样的，执行时不行的
     */
    ListNodeIntersectionOfTwoLinkedLists test1 = new ListNodeIntersectionOfTwoLinkedLists(2);
    ListNodeIntersectionOfTwoLinkedLists test2 = new ListNodeIntersectionOfTwoLinkedLists(0);
    ListNodeIntersectionOfTwoLinkedLists test3 = new ListNodeIntersectionOfTwoLinkedLists(9);
    ListNodeIntersectionOfTwoLinkedLists test4 = new ListNodeIntersectionOfTwoLinkedLists(1);
    ListNodeIntersectionOfTwoLinkedLists test5 = new ListNodeIntersectionOfTwoLinkedLists(2);
    ListNodeIntersectionOfTwoLinkedLists test6 = new ListNodeIntersectionOfTwoLinkedLists(4);

    test2.next = test3;
    test3.next = test4;
    test4.next = test5;
    test5.next = test6;

    ListNodeIntersectionOfTwoLinkedLists result = new IntersectionOfTwoLinkedLists().getIntersectionNode(test1, test2);

    System.out.println(result.val);

  }

  public ListNodeIntersectionOfTwoLinkedLists getIntersectionNode(ListNodeIntersectionOfTwoLinkedLists headA, ListNodeIntersectionOfTwoLinkedLists headB) {

    int lengthA = getListLength(headA);
    int lengthB = getListLength(headB);

    int nLengthDif = lengthA - lengthB;
    ListNodeIntersectionOfTwoLinkedLists longHead = headA;
    ListNodeIntersectionOfTwoLinkedLists shortHead = headB;

    if (lengthB > lengthA) {
      longHead = headB;
      shortHead = headA;
      nLengthDif = lengthB - lengthA;
    }

    //先在长链表上走几步，再同时在两个链表上遍历
    for (int i = 0; i < nLengthDif; i++) {
      longHead = longHead.next;
    }

    while (longHead != null && shortHead != null && longHead.val != shortHead.val) {
      longHead = longHead.next;
      shortHead = shortHead.next;
    }

    return longHead;


  }

  private int getListLength(ListNodeIntersectionOfTwoLinkedLists head) {

    int length = 0;
    ListNodeIntersectionOfTwoLinkedLists p = head;
    while (p != null) {
      length++;
      p = p.next;
    }

    return length;
  }

}


class ListNodeIntersectionOfTwoLinkedLists {
  int val;
  ListNodeIntersectionOfTwoLinkedLists next;
  ListNodeIntersectionOfTwoLinkedLists(int x) {
    val = x;
    next = null;
  }
}