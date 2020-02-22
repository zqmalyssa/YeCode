package com.qiming.algorithm.leetcode;

/**
 * 最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 输入: [1,3,5,4,7] 输出: 3   输入: [2,2,2,2,2]  输出: 1
 *
 * 思路：类似滑动窗口一类的解题思路
 *
 */
public class LongestContinuousIncreasingSubsequence {

  public static void main(String[] args) {
    int nums[] = {1,3,5,4,2,3,4,5};
    System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums));
  }

  public int findLengthOfLCIS(int[] nums) {

    /**
     * 自己写的
     */
//    if (nums.length == 0) {
//      return 0;
//    }
//
//    if (nums.length == 1) {
//      return 1;
//    }
//
//    int longest = 1;
//    int tmp = 1;
//    for (int i = 1; i < nums.length; i++) {
//      if ((nums[i] - nums[i-1]) > 0) {
//        tmp++;
//      } else {
//        longest = Math.max(longest, tmp);
//        //注意这边tmp为1
//        tmp = 1;
//      }
//    }
//    //最后一定要记得比较下，因为有一直增的情况
//    longest = Math.max(longest, tmp);
//    return longest;

    /**
     * 标准滑动窗口解答，上面的tmp用下标做替换
     */

    int ans = 0, anchor = 0;
    for (int i = 0; i < nums.length; ++i) {
      //这边if i > 0的技巧，跳过了没有值和一个值
      if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
      ans = Math.max(ans, i - anchor + 1);
    }
    return ans;


  }



}
