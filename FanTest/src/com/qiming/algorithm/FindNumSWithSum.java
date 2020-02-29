package com.qiming.algorithm;

/**
 * 和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：输入：nums = [2,7,11,15], target = 9  输出：[2,7] 或者 [7,2]
 *
 * 思路：应用好递增的特性，用两个指针指向第一个元素，跟最后有个元素，后面就是条件判断移哪个元素了
 *
 */
public class FindNumSWithSum {

  public int[] twoSum(int[] nums, int target) {

    int low = 0;
    int high = nums.length - 1;
    int result[] = {-1,-1};
    while (low < high) {

      int sum = nums[low] + nums[high];

      if (sum == target) {
        result[0] = nums[low];
        result[1] = nums[high];
        return result;
      } else if (sum > target) {
        high--;
      } else {
        low++;
      }
    }
    return result;

  }

}
