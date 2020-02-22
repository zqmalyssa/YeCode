package com.qiming.algorithm.leetcode;

/**
 * 递减元素使数组呈锯齿状
 *
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 * 思路 因为只能降，所以计算两种（奇数位降和偶数位降）分别需要的次数，取小的那个就行了，注意判断好边界
 */
public class DecreaseElementsToMakeArrayZigzag {

  public static void main(String[] args) {
//    int[] test = {9,6,1,6,2};
    int[] test1 = {1,2,3};
    System.out.println(new DecreaseElementsToMakeArrayZigzag().movesToMakeZigzag(test1));
  }

  public int movesToMakeZigzag(int[] nums) {

    int len = nums.length;
    int result1 = 0, result2 = 0;
    for (int i = 0; i < len; i++) {
      //偶数位置
      if (i % 2 == 0) {
        int d1,d2;
        if (i > 0 && nums[i] >= nums[i-1]) {
          d1 = nums[i] - nums[i-1] + 1;
        } else {
          d1 = 0;
        }
        if (i < len-1 && nums[i] >= nums[i+1]) {
          d2 = nums[i] - nums[i+1] + 1;
        } else {
          d2 = 0;
        }
        result1 += Math.max(d1, d2);
      } else {
        //奇数位置
        int d1,d2;
        if (i > 0 && nums[i] >= nums[i - 1]) {
          d1 = nums[i] - nums[i - 1] + 1;
        } else {
          d1 = 0;
        }
        if (i < len - 1 && nums[i] >= nums[i + 1]) {
          d2 = nums[i] - nums[i + 1] + 1;
        } else {
          d2 = 0;
        }
        result2 += Math.max(d1, d2);
      }

    }
    return Math.min(result1, result2);
  }

}
