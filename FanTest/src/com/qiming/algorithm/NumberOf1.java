package com.qiming.algorithm;

/**
 * 二进制中1的个数
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 思路：发现数值减1的规律，当数值减1的时候，其实就把数的最右边的1变成了0，并且将其后的所有位取反，那么与的结果是那位1到后面的位数都为0，高位不变，这也就找到了一个1
 *
 */
public class NumberOf1 {

  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      n = (n-1) & n;
    }
    return count;
  }

}
