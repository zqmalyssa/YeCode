package com.qiming.algorithm;

/**
 * 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1: 输入: 2.00000, 10 输出: 1024.00000  示例 2: 输入: 2.10000, 3 输出: 9.26100
 *
 * -100.0 < x < 100.0  其数值范围是 [−2^31, 2^31 − 1]
 *
 * 思路：OF中思路，x^n次方其实可以分奇偶拆成 x^(n/2) * x^(n/2) 和 x^(n-1/2) * x^(n-1/2) * x，这样。然后考虑临界值和负数比正数多
 *
 */
public class Power {

  public static void main(String[] args) {

    new Power().myPow(2,8);

  }

  public double myPow(double x, int n) {

    if (x == 0 && n <= 0) {
      return 0;
    }

    long count = n;
    boolean isNeg = false;

    //n为负数时取得正可能越界，估扩大范围
    if (count < 0) {
      isNeg = true;
      count = -1 * count;
    }

    double res = 1;

    while (count != 0) {
      if ((count & 1) == 1) {
        //奇数的情况，需要乘一个自己，其余都是倍乘
        res = res * x;
      }
      count >>= 1;
      x *= x;
    }

    return isNeg ? 1 / res : res;
  }


}
