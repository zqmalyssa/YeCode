package com.qiming.algorithm.leetcode;

/**
 * 爱吃香蕉的珂珂
 *
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）
 *
 * 输入: piles = [3,6,7,11], H = 8  输出: 4
 *
 * 1 <= piles.length <= 10^4，piles.length <= H <= 10^9，1 <= piles[i] <= 10^9 = 1_000_000_000
 *
 * 思路，二分查找解决问题
 */
public class KokoEatingBananas {

  public static void main(String[] args) {
    System.out.println(1_000_000_000);
    System.out.println(Integer.MAX_VALUE);
  }

  /**
   * 如果珂珂能以 K 的进食速度最终吃完所有的香蕉（在 H 小时内），那么她也可以用更快的速度吃完。当珂珂能以 K 的进食速度吃完香蕉时，
   * 我们令 possible(K) 为 true，那么就存在 X 使得当 K >= X 时， possible(K) = True。
   * 举个例子，当初始条件为 piles = [3, 6, 7, 11] 和 H = 8 时，存在 X = 4 使得 possible(1) = possible(2) = possible(3) = False，
   * 且 possible(4) = possible(5) = ... = True。
   * 我们可以二分查找 possible(K) 的值来找到第一个使得 possible(X) 为 True 的 X：这将是我们的答案。我们的循环中，不变量 possible(hi) 总为 True， lo 总小于等于答案
   * @param piles
   * @param H
   * @return
   */
  public int minEatingSpeed(int[] piles, int H) {
    //相当于就是求这个两个值区间的二分查找
    int lo = 1;
    int hi = 1_000_000_000; //最大是10^9次方
    //注意这边是小于
    while (lo < hi) {
      int mi = (lo + hi) / 2;
      if (!possible(piles, H, mi))
        lo = mi + 1;
      else
        hi = mi;
    }

    return lo;
  }

  // Can Koko eat all bananas in H hours with eating speed K?
  public boolean possible(int[] piles, int H, int K) {
    int time = 0;
    for (int p: piles)
      //一定要有减1和加1
      time += (p-1) / K + 1;
    return time <= H;
  }


}
