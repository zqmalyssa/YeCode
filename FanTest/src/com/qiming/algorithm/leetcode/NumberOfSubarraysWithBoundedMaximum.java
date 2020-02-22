package com.qiming.algorithm.leetcode;

/**
 * 区间子数组个数
 *
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 *
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。 数组 A 的长度范围在[1, 50000]。
 *
 * 思路 其实可以用标记，小于L的标0，L和R之间的标1，大于R的标2，就是求被2分割的，子数组里至少包含一个1的个数，然后就转换成
 *
 * 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数（因为最大元素小于L的子数组个数肯定包含在最大元素小于等于R的子数组个数）
 *
 */
public class NumberOfSubarraysWithBoundedMaximum {

  public int numSubarrayBoundedMax(int[] A, int L, int R) {

    return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L-1);

  }

  private int numSubarrayBoundedMax(int[] A, int Max) {
    int res = 0;
    int numSubarray = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] <= Max) {
        numSubarray++;
        res += numSubarray;
      } else {
        numSubarray = 0;
      }
    }
    return res;
  }

  /**
   * 暴力解法，肯定超出时间
   * @param A
   * @param L
   * @param R
   * @return
   */
  public int numSubarrayBoundedMaxByViolence(int[] A, int L, int R) {

    int result = 0;

    for (int i = 0; i < A.length; i++) {
      int max = A[i];
      for (int j = i; j < A.length; j++) {
        max = Math.max(A[j], max);
        if (L <= max && max <= R) {
          result++;
        }
      }
    }

    return result;

  }

}
