package com.qiming.algorithm;

/**
 * 斐波那契数列
 */
public class Fibonacci {

  public static void main(String args[]) {
    System.out.println(fibonacci(5));
    System.out.println(fibonacciGood(8));
  }

  /**
   * 这种递归算法重复的计算太多了
   * @param n
   * @return
   */
  private static int fibonacci(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n -2 );
  }

  /**
   * 从下往上计算，先计算0跟1得到f(2)，再计算1跟2得到f(3)，时间复杂度只有O(n)
   * @param n
   * @return
   */
  private static int fibonacciGood(int n) {
    int result[] = {0, 1};
    if (n < 2) {
      return result[n];
    }
    int fibNMinusOne = 1;
    int fibNMinusTwo = 0;
    int fibN = 0;
    for (int i = 2; i <= n; i++) {
      fibN = fibNMinusOne + fibNMinusTwo;
      fibNMinusTwo = fibNMinusOne;
      fibNMinusOne = fibN;
    }
    return fibN;
  }

}
