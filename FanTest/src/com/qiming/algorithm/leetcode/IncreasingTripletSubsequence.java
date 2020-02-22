package com.qiming.algorithm.leetcode;

/**
 * 递增的三元子序列
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下: 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1: 输入: [1,2,3,4,5] 输出: true
 *
 * 思路，注意下标是可以不连续的，只要有子序列就行的，变换small和big，一直保持一对递增的，如果小于这对递增的最小值，就更新最小值，如果介于最小值和递增值之间(中间值)，就更新递增值(中间值)
 *
 * 最后只要有一个大于中间值的就行了
 *
 */
public class IncreasingTripletSubsequence {

  public boolean increasingTriplet(int[] nums) {
    int i = 0;
    int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;

    while (i < nums.length) {
      if (nums[i] < small) {
        small = nums[i];
      } else if (nums[i] > small && nums[i] <= big) {
        big = nums[i];
      } else if (nums[i] > big) {
        return true;
      }
      i++;
    }
    return false;
  }

}
