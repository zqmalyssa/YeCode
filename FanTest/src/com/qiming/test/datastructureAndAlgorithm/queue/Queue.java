package com.qiming.test.datastructureAndAlgorithm.queue;

import com.qiming.test.datastructureAndAlgorithm.common.QueueEmptyException;

public interface Queue {

  //返回队列的大小
  public int getSize();

  //判断队列是否为空
  public boolean isEmpty();

  //数据元素e入队
  public void enqueue(Object e);

  //队首元素出队
  public Object dequeue() throws QueueEmptyException;

  //取队首元素
  public Object peek() throws QueueEmptyException;

}
