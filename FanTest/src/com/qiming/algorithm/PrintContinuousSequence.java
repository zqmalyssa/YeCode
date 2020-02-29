package com.qiming.algorithm;


import java.util.LinkedList;

/**
 * 和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 思路：考虑两个指针low和high，而low是不能超过(1+s)/2的，不然直接超过s了，利用排序的特性增加low，减小high
 *
 */
public class PrintContinuousSequence {

  public int[][] findContinuousSequence(int target) {

    if (target < 3) {
      return new int[0][0];
    }


    LinkedList<int []> list = new LinkedList();

    int low = 1;
    int high = 2;
    int curSum = low + high;
    int middle = (1 + target) / 2;

    while (low < middle) {
      if (curSum == target) {
        int add[] = new int[high-low+1];
        for (int j = 0, k = low; j < add.length; j++, k++) {
          add[j] = k;
        }
        list.add(add);
      }

      //如果是大于了target。要循环挪下low
      while (curSum > target && low < middle) {
        curSum -= low;
        low++;
        //可能会有值相等的，这里也要判断下
        if (curSum == target) {
          int add[] = new int[high-low+1];
          for (int j = 0, k = low; j < add.length; j++, k++) {
            add[j] = k;
          }
          list.add(add);
        }
      }

      //都要做的
      high++;
      curSum += high;
    }

    int result[][] = new int[list.size()][];

    return list.toArray(result);

  }

}
