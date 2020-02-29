package com.qiming.algorithm.ms;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestMain3 {


  private NodeTestMain3 head = new NodeTestMain3(0);
  private NodeTestMain3 tail = new NodeTestMain3(0);

  public TestMain3() {
    this.head.next = tail;
    this.tail.pre = head;
    this.head.pre = null;
    this.tail.next = null;
  }

  private static volatile int size;

  private Semaphore full = new Semaphore(10);
  private Semaphore empty = new Semaphore(4);


  public static void main(String[] args) {

    TestMain3 test = new TestMain3();

    for (int i = 0; i < 12; i++) {

      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            test.offer(new NodeTestMain3(0));
          } catch (InterruptedException e) {
            System.out.println("不能再放元素了");
            e.printStackTrace();
          }
        }
      }).start();

    }

//    for (int i = 0; i < 2; i++) {
//
//      new Thread(new Runnable() {
//        @Override
//        public void run() {
//          try {
//            test.poll();
//            System.out.println(Thread.currentThread().getName() + "是poll线程，现在的size是 " + size);
//          } catch (InterruptedException e) {
//            System.out.println("没有新的元素了");
//            e.printStackTrace();
//          }
//        }
//      }).start();
//
//    }

  }

  public synchronized void offer(NodeTestMain3 node) throws InterruptedException {

    full.acquire();

//    node.pre = tail.pre;
//    node.next = tail;
//    tail.pre.next = node;
    System.out.println(Thread.currentThread().getName() + "是offer开始线程，现在的size是 " + size);
    size++;
    System.out.println(Thread.currentThread().getName() + "是offer结束线程，现在的size是 " + size);

    empty.release();

  }

  public synchronized NodeTestMain3 poll() throws InterruptedException {

    empty.acquire();

//    NodeTestMain3 result = head.next;
//    head.next.next.pre = head;
//    head.next = head.next.next;
    size--;

    full.release();

    return new NodeTestMain3(0);
  }


}

class NodeTestMain3 {

  int val;
  NodeTestMain3 pre;
  NodeTestMain3 next;

  public NodeTestMain3(int val) {
    this.val = val;
  }
}
