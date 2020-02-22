package com.qiming.algorithm.leetcode;

/**
 * 卡牌分组
 *
 * 给定一副牌，每张牌上都写着一个整数。此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组
 *
 * 1、每组都有 X 张牌。 2、组内所有的牌上都写着相同的整数。 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例 1：输入：[1,2,3,4,4,3,2,1] 输出：true 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4] 示例 3：输入：[1] 输出：false 解释：没有满足要求的分组。
 *
 * 思路：用最大公约数，还有辅助数组存储
 *
 */
public class XOfAKindInADeckOfCards {

  public static void main(String[] args) {
    System.out.println(new XOfAKindInADeckOfCards().gcd(9,6));
  }

  public boolean hasGroupsSizeX(int[] deck) {

    int[] count = new int[10000];

    //用数组空间存储
    for (int i = 0; i < deck.length; i++) {
      count[deck[i]]++;
    }

    int g = -1;
    for (int i = 0; i < 10000; i++) {
      if (count[i] > 0) {
        if (g == -1) {
          g = count[i];
        } else {
          g = gcd(g, count[i]);
        }
      }
    }

    return g >= 2;

  }

  //x,y不分谁大谁小的，求最大公约数
  private int gcd(int x, int y) {
    return x == 0 ? y : gcd(y%x, x);
  }

}
