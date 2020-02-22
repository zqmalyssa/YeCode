package com.qiming.algorithm.leetcode;

/**
 * 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例: 输入: a = 1, b = 1 输出: 2
 *
 * 提示：a, b 均可能是负数或 0  结果不会溢出 32 位整数
 *
 * 思路：要知道这个a + b等价于计算(a ^ b) + ((a & b) << 1)，其中((a & b) << 1)表示进位。因此令a等于(a & b) << 1，令b等于a ^ b，直到a变成0，然后返回b。
 *
 */
public class AddWithNoNormal {

  public int add(int a, int b) {
    while (a != 0) {
      int temp = a ^ b;
      a = (a & b) << 1;
      b = temp;
    }
    return b;
  }

}
