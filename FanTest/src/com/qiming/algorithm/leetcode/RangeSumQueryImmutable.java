package com.qiming.algorithm.leetcode;

/**
 * 区域和检索 - 数组不可变
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例： 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()  sumRange(0, 2) -> 1  sumRange(2, 5) -> -1  sumRange(0, 5) -> -3
 *
 * 你可以假设数组不可变。会多次调用 sumRange 方法。
 *
 * 思路：暴力办法是超时的，i-j的和相当于sum[j] - sum[i-1]，sum为0到下标的和
 *
 */
public class RangeSumQueryImmutable {

  private static int[] sums;

  public RangeSumQueryImmutable(int[] nums) {
//    this.nums = nums;
    sums = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      sums[i+1] = sums[i] + nums[i];
    }
  }

  public int sumRange(int i, int j) {
//    int sum = 0;
//    for (int k = i; k <= j ; k++) {
//      sum += nums[k];
//    }
//    return sum;
    return sums[j+1] - sums[i];
  }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */


