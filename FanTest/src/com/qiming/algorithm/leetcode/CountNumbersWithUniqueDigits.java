package com.qiming.algorithm.leetcode;

/**
 * 计算各个位数不同的数字个数
 *
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。
 *
 * 示例: 输入: 2 输出: 91 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 思路：数学题
 *
 * n=1: res=10
 *
 * n=2: res=9*9+10=91 # 两位数第一位只能为1-9，第二位只能为非第一位的数，加上一位数的所有结果
 *
 * n=3: res=9 * 9 * 8+91=739 # 三位数第一位只能为1-9，第二位只能为非第一位的数，第三位只能为非前两位的数，加上两位数的所有结果
 *
 * n=4: res=9 * 9 * 8 * 7+739=5275 # 同上推法
 *
 * n>10: 就不能有都不一样的数字了，所以有Math.min()
 *
 */
public class CountNumbersWithUniqueDigits {

  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    int mul = 9;
    int result = 10;
    for (int i = 1; i < Math.min(n, 10); i++) {
      mul *= 10 - i;
      result += mul;
    }
    return result;
  }

}
