package com.qiming.algorithm.leetcode;

/**
 * 连续数列
 *
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 *
 * 示例：输入： [-2,1,-3,4,-1,2,1,-5,4]  输出： 6  解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 思路：大老板sum，和他的小喽啰b，以收割土地（数值）为生。b拿着sum的资产出门，遇到数值以后，b先看自己的资产，如果是正的，那么直接掠夺别人相加；
 * 如果是负的，就把自己的扔掉，让别人的数直接覆盖，因为如果相加的话，自己的负资产一定会拖后腿。然后带着自己的新资产情况回去和sum比较，
 * 来对比自己收割情况，情况好的话更新大老板数据，不好的话出去掠夺，以保持sum的总和是最大的。并且，b累计的和一直是连续计算的。这个弯子有点绕的
 *
 * 还有动态规划，dp[i]表示，从0到i，在包含元素i的情况下的最大值，找到dp中的最大值即可
 *
 */
public class ContiguousSequenceLCCI {

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
