package com.qiming.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 思路：跟栈那个相似，需要用到辅助最大值队列，注意push和pop都需要有操作
 */
public class MaxQueue {

  private Queue<Integer> queue;
  //辅助队列，由大到小排列的队列，
  private Deque<Integer> maxQueue;

  public MaxQueue() {
    this.queue = new ArrayDeque<>();
    this.maxQueue = new ArrayDeque<>();
  }

  public int max_value() {
    if (maxQueue.isEmpty()) {
      return -1;
    }
    return maxQueue.peek();
  }

  public void push_back(int value) {
    queue.add(value);
    //比它小的就没有意义了，从队尾删除
    while (!maxQueue.isEmpty() && value > maxQueue.getLast()) {
      maxQueue.pollLast();
    }
    maxQueue.add(value);
  }

  public int pop_front() {
    if (queue.isEmpty()) {
      return -1;
    }
    int ans = queue.poll();
    if (ans == maxQueue.peek()) {
      maxQueue.poll();
    }
    return ans;
  }

}
