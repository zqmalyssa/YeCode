package com.qiming.algorithm;

/**
 * 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1: 输入: [0,1,3] 输出: 2
 *
 * 思路：其实该是用二分的，但是下面这个写的也很快啊
 *
 */
public class MissingNumber {

  public int missingNumber(int[] nums) {

    int i = 0;
    for (; i < nums.length; i++) {
      if (i != nums[i]) {
        if (i == 0) {
          return nums[i] - 1;
        } else {
          return i;
        }
      }
    }

    return i + 1;
  }

}
