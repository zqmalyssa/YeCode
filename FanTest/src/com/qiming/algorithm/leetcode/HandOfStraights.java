package com.qiming.algorithm.leetcode;

import java.util.TreeMap;

/**
 * 一手顺子
 *
 * 爱丽丝有一手（hand）由整数数组给定的牌。 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3   输出：true  解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 *
 * 思路：TreeMap的一个应用，因为手中最小的牌也一定是某个分组中的起始牌，所以反复从手中最小的牌开始组建一个长度为 W 的组。建不出来就返回false
 *
 *
 */
public class HandOfStraights {

  public boolean isNStraightHand(int[] hand, int W) {

    TreeMap<Integer, Integer> count = new TreeMap();
    //现将所有的数据和个数的映射存到treemap中，有序的
    for (int card : hand) {
      if (!count.containsKey(card)) {
        count.put(card, 1);
      } else {
        count.replace(card, count.get(card) + 1);
      }
    }

    while (count.size() > 0) {
      int first = count.firstKey();
      for (int card = first; card < first + W; card++) {
        if (!count.containsKey(card)) {
          return false;
        }
        int c = count.get(card);
        if (c == 1) {
          count.remove(card);
        } else {
          count.replace(card, c - 1);
        }
      }
    }

    return true;

  }

}
