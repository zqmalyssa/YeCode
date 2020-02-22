package com.qiming.algorithm.nowcoder;

/**
 * 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 * 可以理解成不能两个for循环，也不要使用辅助存储
 * 思路是单链表的快速排序（n log n）和单链表的归并排序
 */
public class SortList {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(5);
    ListNode l3 = new ListNode(10);
    ListNode l4 = new ListNode(25);
    ListNode l5 = new ListNode(13);
    ListNode l6 = new ListNode(7);
    ListNode l7 = new ListNode(48);
    ListNode l8 = new ListNode(31);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    l6.next = l7;
    l7.next = l8;
    new SortList().sortListByBTU(l1);
    while(l1 != null) {
      System.out.println(l1.val);
      l1 = l1.next;
    }
  }

  public ListNode sortList(ListNode head) {
    return quickSort(head,null);
  }

  private ListNode quickSort(ListNode head, ListNode end) {

    if (head != end) {
      ListNode p = partion(head, end);
      quickSort(head, p);
      quickSort(p.next, end);
    }
    return head;
  }


  /**
   * 单链表的partion的思路才关键，需要理清楚
   * 将原链表看做是两个链表，左链表和右链表，
   * @param head
   * @param end
   * @return
   */
  private ListNode partion(ListNode head, ListNode end) {
    int pivot = head.val;
    ListNode p1 = head;
    ListNode p2 = head.next;

    //这里也包含了只有一个节点的情况
    while(p2 != end) {
      //如果小于基准值，才做处理，否则一直向右移，p2是会始终到最后的，p1根据P2的值决定自己的动作，最后停留在基准点处，那么右子链表的第一个结点是p1的next
      if (p2.val < pivot) {
        //p1向前走
        p1 = p1.next;
        swap(p1, p2);
      }
      p2 = p2.next;
    }
    swap(head, p1);
    return p1;
  }

  private void swap(ListNode p1, ListNode p2) {
    int tmp = p1.val;
    p1.val = p2.val;
    p2.val = tmp;
  }

  /**
   * 以下是使用归并排序的实现，这边还是用到了递归
   */
  public ListNode sortListByMerge(ListNode head){
    if(head==null || head.next==null){
      return head;
    }
    ListNode mid=findMid(head);
    ListNode right=mid.next;
    //防止内存泄漏
    mid.next=null;
    return merge(sortList(head),sortList(right));
  }
  private ListNode merge(ListNode head1,ListNode head2){
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while(head1!=null && head2!=null){
      if(head1.val<=head2.val){
        cur.next=head1;
        head1=head1.next;
      }else{
        cur.next=head2;
        head2=head2.next;
      }
      cur=cur.next;
    }
    if(head1!=null){
      cur.next=head1;
    }else if(head2!=null){
      cur.next=head2;
    }
    //相当于有头结点
    return dummy.next;
  }
  private ListNode findMid(ListNode head){
    if(head==null){
      return head;
    }
    ListNode slow=head;
    ListNode fast=head;
    while(fast.next!=null && fast.next.next!=null){
      fast=fast.next.next;
      slow=slow.next;
    }
    return slow;
  }

  /**
   * 上面两个都还是用了递归，下面还有个bottom-to-up的思想，不用递归，完成归并排序
   * 可以解决空间复杂度是O(1)的限制
   * 1. 双路归并，2. cut， 3. dummyHead大法
   */
  private ListNode sortListByBTU(ListNode head) {
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
    dummyHead.next = head;
    // 先统计长度f
    ListNode p = dummyHead.next;
    int length = 0;
    while(p != null){
      ++length;
      p = p.next;
    }
    // 循环开始切割和合并，<<是乘以2，所以这里的时间复杂度是O(nlogn)
    // 就是先两个两个的 merge，完成一趟后，再 4个4个的 merge，直到结束
    for(int size = 1; size < length; size <<= 1){
      ListNode cur = dummyHead.next;
      ListNode tail = dummyHead;
      while(cur != null){
        ListNode left = cur;
        ListNode right = cut(cur, size); // 链表切掉size 剩下的返还给right
        cur = cut(right, size); // 链表切掉size 剩下的返还给cur
        //merge和mergeByBTU一样
        tail.next = mergeByBTU(left, right);  //这步其实是非常关键的！！！，把断开的链表连起来，就是两两之间的连接，指针的特性，你指向的next有值了，别的指针也有值了
        while(tail.next != null){
          tail = tail.next; // 保持最尾端
        }
      }
    }
    return dummyHead.next;
  }

  /**
   * 将链表L切掉前n个节点 并返回后半部分的链表头
   * @param head
   * @param n
   * @return
   */
  public static ListNode cut(ListNode head, int n){
    if(n <= 0) return head;
    ListNode p = head;
    // 往前走n-1步
    while(--n > 0 && p != null){
      p = p.next;
    }
    if(p == null) return null;
    ListNode next = p.next;
    //注意下面的步骤，这就是断链，传进来的head会被断掉，返回后面的
    p.next = null;
    return next;
  }

  /**
   * 合并list1和list2，跟上面merge一样，就是双路归并，分成顺序存储和链表存储
   * @param list1
   * @param list2
   * @return
   */
  public static ListNode mergeByBTU(ListNode list1, ListNode list2){
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = dummyHead;
    while(list1 != null && list2 != null){
      if(list1.val < list2.val){
        p.next = list1;
        list1 = list1.next;
      } else{
        p.next = list2;
        list2 = list2.next;
      }
      p = p.next;
    }
    if(list1 == null){
      p.next = list2;
    } else{
      p.next = list1;
    }
    return dummyHead.next;
  }


}


class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}