package com.qiming.algorithm;

/**
 * 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4] 输出: 6
 *
 * 思路：OF这个和102一样，思路也是一样的，还有动态规划的解法
 *
 */
public class FindGreatestSumOfSubArray {

  public int maxSubArray(int[] nums) {
    int b = nums[0];
    int sum = b;
    for (int i = 1; i < nums.length; i++) {
      if (b < 0) {
        b = nums[i];
      } else {
        b += nums[i];
      }
      if (b > sum) {
        sum = b;
      }
    }
    return sum;

  }

}
