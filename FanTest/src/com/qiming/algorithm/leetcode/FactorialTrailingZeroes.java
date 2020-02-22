package com.qiming.algorithm.leetcode;

/**
 * 阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 输入: 3  输出: 0  解释: 3! = 6, 尾数中没有零。  输入: 5  输出: 1  解释: 5! = 120, 尾数中有 1 个零. 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 思路：数学题，就是算5的个数，因为只有5*2为10了才会在后面加零，而有5的时候必出现过2的因子，因为2是2个2个一走，5是5个5个一走，但是硬算每个值的5的个数会超时
 *
 * 所以还要再想，5每隔5间隔会出现一次，而5*5=25间隔会出现两次，5*5*5=125间隔会出现三次，所以其实最后算的是N/5+N/25+N/125+...但是分母太大会溢出，N= N/5计算
 *
 */
public class FactorialTrailingZeroes {

  public int trailingZeroes(int n) {

    int count = 0;
    while (n > 0) {
      count += n / 5;
      n = n / 5;
    }
    return count;
  }

}
