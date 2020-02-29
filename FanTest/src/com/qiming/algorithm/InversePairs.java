package com.qiming.algorithm;

/**
 * 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1: 输入: [7,5,6,4] 输出: 5  0 <= 数组长度 <= 50000
 *
 * 思路：循环方式不可取，这题用到的是归并和递归，hard，直接OF看
 *
 */
public class InversePairs {

  public int reversePairs(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }

    int copy[] = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      copy[i] = nums[i];
    }

    int count = InversePairsCore(nums, copy, 0, nums.length - 1);

    return count;
  }

  private int InversePairsCore(int nums[], int copy[], int start, int end) {

    if (start == end) {
      copy[start] = nums[start];
      return 0;
    }

    int length = (end - start) / 2;
    int left = InversePairsCore(copy, nums, start, start + length);
    int right = InversePairsCore(copy, nums, start + length + 1, end);

    //i初始化为前半段最后一个数字的下标
    int i = start + length;

    //j初始化为后半段最后一个数字的下标
    int j = end;
    int indexCopy = end;
    int count = 0;
    while (i >= start && j>= start + length + 1) {
      if (nums[i] > nums[j]) {
        copy[indexCopy--] = nums[i--];
        count += j - start - length;
      } else {
        copy[indexCopy--] = nums[j--];
      }
    }

    for (; i >= start ; --i) {
      copy[indexCopy--] = nums[i];
    }

    for (; j >= start + length + 1 ; --j) {
      copy[indexCopy--] = nums[j];
    }

    return left + right + count;

  }

}
