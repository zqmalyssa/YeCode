package com.qiming.test.datastructureAndAlgorithm.queue;

import com.qiming.test.datastructureAndAlgorithm.common.QueueEmptyException;
import com.qiming.test.datastructureAndAlgorithm.linearlist.SLNode;

/**
 * 队列的链式存储，使用front作为链表的头结点，rear指向尾结点
 */

public class QueueSLinked implements Queue{

  private SLNode front;
  private SLNode rear;
  private int size;

  public QueueSLinked() {
    front = new SLNode();
    rear = new SLNode();
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(Object e) {
    SLNode p = new SLNode(e, null);
    rear.setNext(p);
    rear = p;
    size++;
  }

  public Object dequeue() throws QueueEmptyException {
    if (size < 1) {
      throw new QueueEmptyException("错误：队列为空");
    }
    SLNode p = front.getNext();
    front.setNext(p.getNext());
    size--;
    //这边要处理一下，空的话，rear指向头结点
    if (size < 1) {
      rear = front;
    }
    return p.getData();
  }

  public Object peek() throws QueueEmptyException {
    if (size < 1) {
      throw new QueueEmptyException("错误：队列为空");
    }
    return front.getNext().getData();
  }
}
