package com.qiming.algorithm.leetcode;

/**
 * 快乐数
 *
 * 编写一个算法来判断一个数是不是“快乐数”。一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 输入: 19 输出: true
 *
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 思路：使用快慢指针思想，如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
 *
 */
public class HappyNumber {

  public static void main(String[] args) {
    System.out.println(new HappyNumber().squareSum(19));
  }

  public boolean isHappy(int n) {
    int fast = n;
    int slow = n;
    do {
      slow = squareSum(slow);
      fast = squareSum(fast);
      fast = squareSum(fast);
    } while (slow != fast);
    if (fast == 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 求数字的平方和，跟10有关
   * @param m
   * @return
   */
  private int squareSum(int m) {

    int squareSum = 0;
    while (m != 0) {
      squareSum += (m%10)*(m%10);
      m /= 10;
    }
    return squareSum;
  }

}
