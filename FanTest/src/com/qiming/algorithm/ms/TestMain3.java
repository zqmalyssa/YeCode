package com.qiming.algorithm.ms;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 模拟阻塞队列
 *
 * 生产者和消费者，不要用那种简便的方法做，结合线程池，再结合双端队列
 *
 *
 */
public class TestMain3 {


  private NodeTestMain3 head;
  private NodeTestMain3 tail;

  private Semaphore full;
  private Semaphore empty;
  private Semaphore mutex;

  private static volatile int size;

  public TestMain3(int capacity) {
    this.full = new Semaphore(capacity);
    this.empty = new Semaphore(0);
    this.mutex = new Semaphore(1);

    this.head = new NodeTestMain3(0);
    this.tail = new NodeTestMain3(0);

    this.head.next = tail;
    this.tail.pre = head;
    this.head.pre = null;
    this.tail.next = null;
  }


  public static void main(String[] args) {

    TestMain3 test = new TestMain3(10);

    Producer producer1 = new Producer(test);
    Producer producer2 = new Producer(test);
    Producer producer3 = new Producer(test);

    Consumer consumer1 = new Consumer(test);
    Consumer consumer2 = new Consumer(test);
    Consumer consumer3 = new Consumer(test);

    Thread thread1 = new Thread(new Producer(test), "生产者1");
    Thread thread2 = new Thread(new Producer(test), "生产者2");
    Thread thread3 = new Thread(new Producer(test), "生产者3");

    Thread thread4 = new Thread(new Consumer(test), "消费者1");
    Thread thread5 = new Thread(new Consumer(test), "消费者2");
    Thread thread6 = new Thread(new Consumer(test), "消费者3");

//    new Thread(producer1, "生产者1").start();
//    new Thread(producer2, "生产者2").start();
//    new Thread(producer3, "生产者3").start();
//
//    new Thread(consumer1, "消费者1").start();
//    new Thread(consumer2, "消费者2").start();
//    new Thread(consumer3, "消费者3").start();

    /**
     * 用好线程池
     */
    ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
        Executors.defaultThreadFactory(), new AbortPolicy());

//    pool.execute(producer1);
//    pool.execute(producer2);
//    pool.execute(producer3);
//
//    pool.execute(consumer1);
//    pool.execute(consumer2);
//    pool.execute(consumer3);

    pool.execute(thread1);
    pool.execute(thread2);
    pool.execute(thread3);

    pool.execute(thread4);
    pool.execute(thread5);
    pool.execute(thread6);


    pool.shutdown();

    /**
     * 下面这种最好不要这样写
     */

//    for (int i = 0; i < 12; i++) {
//
//      new Thread(new Runnable() {
//        @Override
//        public void run() {
//          try {
//            test.offer(new NodeTestMain3(0));
//          } catch (InterruptedException e) {
//            System.out.println("不能再放元素了");
//            e.printStackTrace();
//          }
//        }
//      }).start();
//
//    }

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

  public void offer(NodeTestMain3 node) throws InterruptedException {

    full.acquire();
    mutex.acquire();

    //插入到链表尾部，先指好该结点的前后，再更新左右两边
    node.pre = tail.pre;
    node.next = tail;

    tail.pre.next = node;
    tail.pre = node;

    size++;
    System.out.println(Thread.currentThread().getName() + " 号调用offer方法，现在的size是 " + size);
    mutex.release();
    empty.release();

  }

  public NodeTestMain3 poll() throws InterruptedException {

    empty.acquire();
    mutex.acquire();

    //删除链表的第一个元素，先要判断，删简单，把两头做绑定
    NodeTestMain3 node = checkPosition(head.next);
    node.pre.next = node.next;
    node.next.pre = node.pre;

    size--;
    System.out.println(Thread.currentThread().getName() + " 号调用poll方法，现在的size是 " + size);
    mutex.release();
    full.release();

    return node;
  }

  private NodeTestMain3 checkPosition(NodeTestMain3 node) {
    if (node == null) {
      throw new RuntimeException("删除的元素是null");
    }
    if (node == head) {
      throw new RuntimeException("删除的元素是头结点，非法");
    }
    if (node == tail) {
      throw new RuntimeException("删除的元素是尾结点，非法");
    }
    return node;
  }


}


class Producer implements Runnable {

  TestMain3 queue;

  public Producer(TestMain3 queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    int i = 0;
    while (i < 15) {
      NodeTestMain3 node = new NodeTestMain3(0);
      try {
        queue.offer(node);
        i++;
        System.out.println("我是生产者 " + Thread.currentThread().getName() + " 号，这是我生产的第" + i + "个元素");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}


class Consumer implements Runnable {

  TestMain3 queue;

  public Consumer(TestMain3 queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    int i = 0;
    while (i < 15) {
      try {
        queue.poll();
        i++;
        System.out.println("我是消费者 " + Thread.currentThread().getName() + " 号，这是我消费的第" + i + "个元素");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
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
