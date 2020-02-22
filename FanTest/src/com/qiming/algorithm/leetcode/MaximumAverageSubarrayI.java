package com.qiming.algorithm.leetcode;

/**
 * 子数组最大平均数 I
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1: 输入: [1,12,-5,-6,50,3], k = 4  输出: 12.75  解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 注意:  1 <= k <= n <= 30,000。  所给数据范围 [-10,000，10,000]。
 *
 * 思路：自己的思路不好，一个是空间换时间一个是滑动窗口
 *
 */
public class MaximumAverageSubarrayI {

  public static void main(String[] args) {
    int nums[] = {-1};
    int k = 1;
    System.out.println(new MaximumAverageSubarrayI().findMaxAverage(nums, k));
  }

  public double findMaxAverage(int[] nums, int k) {

    //看题目要求，但是这样写不好
//    double maxAvg = -10000;
//    for (int i = 0; i < nums.length - k + 1; i++) {
//      double tmp = 0;
//      for (int j = i; j < i + k; j++) {
//        tmp += nums[j];
//      }
//      tmp /= k;
//      maxAvg = Math.max(maxAvg, tmp);
//    }
//    return maxAvg;

    //比较好的想法1，辅助数组，空间换时间，记录从0到i数的和先sum，那么k个数字的总和就是sum[i] - sum[i-k]
//    int[] sum = new int[nums.length];
//    sum[0] = nums[0];
//    for (int i = 1; i < nums.length; i++) {
//      sum[i] = sum[i - 1] + nums[i];
//    }
//    double res = sum[k - 1] * 1.0 / k;
//    for (int i = k; i < nums.length; i++) {
//      res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
//    }
//    return res;

    //比较好的想法2，滑动窗口，这个可以想，如果i到i+k的子数组和为x，那么i+1到i+k+1的子数组和就是从x减去i和加上i+k+1
    double sum = 0;
    //第一个累加和
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    double res = sum;
    for (int i = k; i < nums.length; i++) {
      sum += nums[i] - nums[i-k];
      res = Math.max(res, sum);
    }
    return res/k;
  }

}
