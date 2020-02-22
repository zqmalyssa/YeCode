package com.qiming.algorithm.leetcode;

/**
 * 数组拆分 I
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 输入: [1,4,3,2] 输出: 4 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 提示: n 是正整数,范围在 [1, 10000]. 数组中的元素范围在 [-10000, 10000].
 *
 * 思路，排序后，每两组较小的数相加即可，用快排
 *
 */
public class ArrayPartitionI {

  public static void main(String[] args) {
//    int[] a = {4,1,3,6,7,2,9};
    int[] a = {1,2,3,2};
    new ArrayPartitionI().quicksort(a, 0, a.length - 1);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }

  public int arrayPairSum(int[] nums) {
    quicksort(nums, 0, nums.length - 1);
    int sum = 0;
    for (int i = 0; i < nums.length; i = i + 2) {
      sum += nums[i];
    }
    return sum;
  }

  private void quicksort(int[] sums, int low, int high) {
    if (low < high) {
      int partition = partition(sums, low, high);
      quicksort(sums, low, partition - 1);
      quicksort(sums, partition + 1, high);
    }
  }

  private int partition(int[] array, int low, int high) {
    int poivt = array[low];
    while (low < high) {
      while (low < high && array[high] >= poivt) {
        high--;
      }
      array[low] = array[high];
      while (low < high && array[low] <= poivt) {
        low++;
      }
      array[high] = array[low];
    }
    array[low] = poivt;
    return low;
  }

}
