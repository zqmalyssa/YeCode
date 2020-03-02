package com.qiming.algorithm;

/**
 * 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 * 思路：斐波那契数列的变体，想好公式，只是初始化的值不太一样
 *
 */
public class FrogJump {

  public int numWays(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 0) {
      return 1;
    }
    long fibNMinusOne = 1;
    long fibNMinusTwo = 1;
    long fibN = 0;
    for (int i = 2; i <= n; i++) {
      fibN = (fibNMinusOne + fibNMinusTwo) % 1000000007;
      fibNMinusTwo = fibNMinusOne;
      fibNMinusOne = fibN;
    }
    if (fibN == 1000000008) {
      return 1;
    }
    return (int)fibN;

  }

}
