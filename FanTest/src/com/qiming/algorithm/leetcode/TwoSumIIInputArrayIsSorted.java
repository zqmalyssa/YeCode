package com.qiming.algorithm.leetcode;

/**
 * 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 思路：自己写的速度不行，那么还是要想到双指针法，这边的思想是一个是小指针，一个是大指针，如果和大于target，则大指针就减小，如果小于target，就小指针增大
 *
 */
public class TwoSumIIInputArrayIsSorted {

  public int[] twoSum(int[] numbers, int target) {

    /**
     * 自己的简单写法，不算最优
     */
//    if (numbers.length < 2) {
//      return new int[2];
//    }
//
//    int[] result = new int[2];
//    for (int i = 0; i < numbers.length - 1; i++) {
//      for (int j = i + 1; j < numbers.length; j++) {
//        if (numbers[i] + numbers[j] == target) {
//          result[0] = i + 1;
//          result[1] = j + 1;
//        } else if (numbers[i] + numbers[j] > target) {
//          break;
//        }
//      }
//    }
//
//    return result;

    /**
     * 双指针法
     */
    int[] result = new int[2];
    int low = 0, high = numbers.length - 1;
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      if (sum == target) {
        result[0] = low + 1;
        result[1] = high + 1;
        return result;
      } else if (sum < target) {
        low++;
      } else {
        high--;
      }
    }
    return result;
  }

}
