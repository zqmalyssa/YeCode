package com.qiming.algorithm.leetcode;

/**
 * 水壶问题
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：1 装满任意一个水壶 2 清空任意一个水壶 3 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 思路 ax + by = z 求是否有合理的解 ，x ，y 为系数，化简 a * t1 * k + b * t2 * k == z;，然后 k * (a * t1 + b * t2) = z;
 * 也就是说z为 a 和 b 的gcd 的倍数 特判为 0 的时候 以及 使得等式成立的基本条件 x + y >= z
 * 也就是先要求出x和y的最大公约数
 */
public class WaterAndJugProblem {

  /**
   * x + y是z的倍数
   * @param x
   * @param y
   * @param z
   * @return
   */
  public boolean canMeasureWater(int x, int y, int z) {
    if (x == 0 && y == 0) {
      return z == 0;
    }
    return z == 0 || (z % gcd(x, y) == 0 && x + y >= z);
  }

  /**
   * 计算x， y的最大公约数
   * @param x
   * @param y
   * @return
   */
  private int gcd(int x, int y) {
    if (y == 0) {
      return x;
    }
    int r = x % y;
    return gcd(y, r);
  }

}
