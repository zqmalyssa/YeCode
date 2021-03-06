package com.qiming.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 *
 * 找出数组中重复的数字。在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1： 输入：[2, 3, 1, 0, 2, 5, 3]  输出：2 或 3  限制： 2 <= n <= 100000
 *
 * 思路：这题其实有很多解，也要看看当时的要求
 *
 */
public class findRepeatNumber {

  public int findRepeatNumber(int[] nums) {

    Set<Integer> set = new HashSet();
    for (int num : nums) {
      if (!set.contains(num)) {
        set.add(num);
      } else {
        return num;
      }
    }
    return -1;
  }

}
