package com.qiming.algorithm;

/**
 * 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1: 输入: nums = [5,7,7,8,8,10], target = 8 输出: 2 示例 2: 输入: nums = [5,7,7,8,8,10], target = 6 输出: 0
 *
 * 思路：O(n)不算这个问题中好的算法。最好的是O(logn)。排序的立马想到就是二分查找，先二分查找到target，再线性搜索的话就是O(n)了，好的方法是二分查找第一个和最后一个位置
 *
 * 写出找到第一个target和找到最后一个target的两个函数
 *
 */
public class NumOfTargetInSortedArray {

  public static void main(String[] args) {
    int nums[] = {5,7,7,8,8,10};
    System.out.println(new NumOfTargetInSortedArray().search(nums, 8));
  }

  public int search(int[] nums, int target) {

    int number = 0;
    if (nums.length > 0) {
      int first = GetFirstK(nums, target, 0, nums.length - 1);
      int last = GetLastK(nums, target, 0, nums.length - 1);

      if (first > -1 && last > -1) {
        number = last - first + 1;
      }
    }
    return number;
  }

  private int GetFirstK(int nums[], int target, int start, int end) {

    if (start > end) {
      return -1;
    }

    int middleIndex = (start + end) / 2;
    int middleData = nums[middleIndex];

    if (middleData == target) {
      if ((middleIndex > 0 && nums[middleIndex - 1] != target) || middleIndex == 0) {
        return middleIndex;
      } else {
        end = middleIndex - 1;
      }
    } else if (middleData > target) {
      end = middleIndex - 1;
    } else {
      start = middleIndex + 1;
    }

    return GetFirstK(nums, target, start, end);

  }

  private int GetLastK(int nums[], int target, int start, int end) {

    if (start > end) {
      return -1;
    }

    int middleIndex = (start + end) / 2;
    int middleData = nums[middleIndex];

    if (middleData == target) {
      if ((middleIndex < nums.length - 1 && nums[middleIndex + 1] != target) || middleIndex == nums.length - 1) {
        return middleIndex;
      } else {
        start = middleIndex + 1;
      }
    } else if (middleData < target) {
      start = middleIndex + 1;
    } else {
      end = middleIndex - 1;
    }

    return GetLastK(nums, target, start, end);

  }

}
