package com.qiming.test.datastructureAndAlgorithm.queue;

import com.qiming.test.datastructureAndAlgorithm.common.QueueEmptyException;

/**
 * Queue的顺序存储实现
 *
 * 循环队列的rear和front在空和满时都处于一个位置，可以另设一个变量size来判断队满
 * 下面代码是采用损失一个存储单元来区分队列空和满
 */
public class QueueArray implements Queue{

  private static final int CAP = 7;
  private Object[] elements;
  private int capacity; //数组的大小
  private int front;  //队首指针
  private int rear; //队尾指针

  public QueueArray() {
    this(CAP);
  }

  public QueueArray(int cap) {
    capacity = cap + 1;
    elements = new Object[capacity];
    front = rear =0;
  }

  public int getSize() {
    return (rear - front + capacity)%capacity;
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public void enqueue(Object e) {
    if (getSize() == capacity-1) {
      expandSpace();
    }
    elements[rear] = e;
    rear = (rear + 1)%capacity;
  }

  public Object dequeue() throws QueueEmptyException {
    if (isEmpty()) {
      throw new QueueEmptyException("错误：队列为空。");
    }
    Object obj = elements[front];
    elements[front] = null;
    front = (front + 1)%capacity;
    return obj;
  }

  public Object peek() throws QueueEmptyException {
    if (isEmpty()) {
      throw new QueueEmptyException("错误：队列为空。");
    }
    return elements[front];
  }

  private void expandSpace() {
    Object[] a = new Object[elements.length*2];
    int i = front; int j = 0;
    while(i != rear) { //将从front开始到rear前一个存储单元的元素复制到新数组
      a[j++] = elements[i];
      i = (i + 1)%capacity;
    }
    elements = a;
    capacity = elements.length;
    front = 0; rear = j;  //设置新的队首，队尾指针
  }
}
