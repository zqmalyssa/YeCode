package com.qiming.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1
 *
 * 思路 我们以存AB两数组之和为例。首先求出A和B任意两数之和sumAB，以sumAB为key，sumAB出现的次数为value，存入hashmap中。
 * 然后计算C和D中任意两数之和的相反数sumCD，在hashmap中查找是否存在key为sumCD。
 *
 */
public class FourSumII {

  public static void main(String[] args) {
    int[] A = {1, 2};
    int[] B = {-2, -1};
    int[] C = {-1, 2};
    int[] D = {0, 2};

    int result = new FourSumII().fourSumCount(A, B, C, D);
    System.out.println(result);

  }

  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        int sumAB = A[i] + B[j];
        if (map.containsKey(sumAB)) {
          map.put(sumAB, map.get(sumAB) + 1);
        } else {
          map.put(sumAB, 1);
        }
      }
    }

    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        int sumCD = -(C[i] + D[j]);
        if (map.containsKey(sumCD)) {
          res += map.get(sumCD);
        }
      }
    }

    return res;
  }


}
