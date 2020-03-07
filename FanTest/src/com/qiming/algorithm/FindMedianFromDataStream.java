package com.qiming.algorithm;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * [2,3,4] 的中位数是 3 [2,3] 的中位数是 (2 + 3) / 2 = 2.5 设计一个支持以下两种操作的数据结构：void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 思路：大顶堆和小顶堆，输入的数据分成两部分，较小的一部分lowPart（最大堆）和较大的一部分highPart（最小堆），如果size是奇数，那么中位数就是lowPart的最大值，堆顶
 * 否则最大值就是lowPart和highPart的堆顶的平均值
 *
 * 每进入一个数，先加入lowPart，然后将lowPart的最大值（堆顶）移出到highPart，如果这时size是奇数，此时highPart将最小值移到lowPart
 *
 */
public class FindMedianFromDataStream {

  private PriorityQueue<Integer> lowPart;
  private PriorityQueue<Integer> highPart;
  private int size;

  /** initialize your data structure here. */
  public FindMedianFromDataStream() {
    //y-x，后减前面，是生成最大堆，默认构造是最小堆，这种函数式的写法只是不写Comparator了
    lowPart = new PriorityQueue<>((x, y) -> y -x);
    highPart = new PriorityQueue<>();
    size = 0;
  }

  public void addNum(int num) {

    size++;
    lowPart.offer(num);
    highPart.offer(lowPart.poll());
    if ((size & 1) == 1) {
      lowPart.offer(highPart.poll());
    }

  }

  public double findMedian() {

    if ((size & 1) == 1) {
      return (double)lowPart.peek();
    } else {
      return (double) (lowPart.peek() + highPart.peek()) / 2;
    }

  }

}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */