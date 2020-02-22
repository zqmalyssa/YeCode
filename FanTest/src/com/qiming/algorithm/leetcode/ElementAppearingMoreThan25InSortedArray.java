package com.qiming.algorithm.leetcode;

/**
 * 有序数组中出现次数超过25%的元素
 *
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。请你找到并返回这个整数
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10] 输出：6    1 <= arr.length <= 10^4   0 <= arr[i] <= 10^5
 *
 * 思路：二分查找不太好理解，正常遍历一遍写吧
 *
 */
public class ElementAppearingMoreThan25InSortedArray {

  public int findSpecialInteger(int[] arr) {

    if (arr.length == 1) {
      return arr[0];
    }

    int limit = arr.length / 4 + 1;

    int result = 1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == arr[i+1]) {
        result++;
        // >= 是会出现[1,1]的情况，不用等于
        if (result >= limit) {
          return arr[i];
        }
      } else {
        result = 1;
      }
    }

    return -1;
  }

}
