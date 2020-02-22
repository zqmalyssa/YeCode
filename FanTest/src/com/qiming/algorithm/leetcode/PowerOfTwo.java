package com.qiming.algorithm.leetcode;

/**
 * 2的幂
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 思路：int类型，移位
 *
 */
public class PowerOfTwo {

  public static void main(String[] args) {

    int k = 1;
    for (int i = 0; i < 30; i++) {
      k = k << 1;
    }
    System.out.println(k);

  }

  public boolean isPowerOfTwo(int n) {

    int k = 1;
    for (int i = 0; i < 31; i++) {
      //注意k移位和判断有前后顺序的哦，影响i的上限是30还是31
      if (k == n) {
        return true;
      }
      k = k << 1;
    }
    return false;
  }

}
