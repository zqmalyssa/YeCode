package com.qiming.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 掷骰子的N种方法
 *
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
 *
 * 思路 不是用回溯，用DP
 * 求状态转移方程，dp[i][j]代表扔i个骰子和为j的所有可能，方程dp[i][j]与dp[i-1]的关系是什么呢，第i次我投了k(1<=k<=f)，那么前i-1次和为j-k，对应dp[i-1][j-k]
 * 于是最终方程是 dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + ... + dp[i-1][j-f]，这些都是可能值，边界条件 dp[1][k] = 1 (1<=k<=min(target, f))
 */
public class NumberOfDiceRollsWithTargetSum {

  private int result;

  private static final int MOD = 1000000007;

  public static void main(String[] args) {
//    int result = new NumberOfDiceRollsWithTargetSum().numRollsToTarget(2, 6, 7);
//    int result = new NumberOfDiceRollsWithTargetSum().numRollsToTarget(2, 5, 10);
    int result = new NumberOfDiceRollsWithTargetSum().numRollsToTarget(3, 6, 14);
//    int result = new NumberOfDiceRollsWithTargetSum().numRollsToTarget(30, 30, 500);
    System.out.println(Integer.MAX_VALUE);
  }

  public int numRollsToTarget(int d, int f, int target) {
    /**
     * 以下是回溯的写法
     */
//    int nums[] = new int[f];
//    for (int i = 0; i < f; i++) {
//      nums[i] = i + 1;
//    }
//    LinkedList<Integer> track = new LinkedList<>();
//    backtrack(nums, track, target, d);
//    return result;

    /**
     * 以下是动态规划的写法
     */
    int [][]dp = new int[31][1001]; //这边是比所有用例多一例
    int min = Math.min(f, target);
    for (int i = 1; i <= min; i++) {
      dp[1][i] = 1;
    }
    //可能的最大值
    int targetMax = d * f;
    for (int i = 2; i <= d ; i++) {
      for (int j = i; j <= targetMax; j++) {
        for (int k = 1; j - k >= 0 && k <= f ; k++) {
          dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % MOD;
        }
      }
    }
    return dp[d][target];
  }

  /**
   * 回溯模板法，在用例为[30,30,500]的情况下，超时了，因为穷举之后的数量是f^d
   * @param nums
   * @param list
   * @param target
   * @param d
   */
  private void backtrack(int nums[], LinkedList<Integer> list, int target, int d) {
    int res = 0;
    if (list.size() == d) {
      for (int i = 0; i < list.size(); i++) {
        res += list.get(i);
      }
      if (target == res) {
        result++;
        return;
      } else {
        return;
      }
    }

    for (int j = 0; j < nums.length; j++) {
      if (res + nums[j] > target) {
        continue;
      }
      list.add(nums[j]);
      backtrack(nums, list, target, d);
      list.removeLast();
    }

  }

}
