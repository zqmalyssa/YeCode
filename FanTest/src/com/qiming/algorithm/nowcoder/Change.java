package com.qiming.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？
 *
 * 思路，这是动态规划题目中经典的找零问题，动态规划之前说了旅行家问题，现在的找零问题需要总结3个方面
 *
 * 暴力解法(递归)，带备忘录的递归算法，动态规划
 */
public class Change {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cost = scanner.nextInt();
    int nums[] = {1, 4, 16, 64};
    System.out.println(calNumWithRecord(1024 - cost, nums));
  }

  /**
   * 暴力解法，递归，时间复杂度爆了，运行是各种不通过，O(k*n^k)的时间复杂度
   * @param change
   * @param nums
   * @return
   */
  private static int calNum(int change, int nums[]) {
    if (change == 0) {
      return 0;
    }
    int result = Integer.MAX_VALUE;
    for (int num : nums) {
      if (change - num < 0) {
        continue;
      }
      int subPro = calNum(change - num, nums);
      //子问题无解
      if (subPro == -1) {
        continue;
      }
      result = Math.min(result, subPro + 1);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  /**
   * 带备忘录的递归算法，时间复杂度不爆了，可以运行通过，O(kn)的时间复杂度
   * @param change
   * @param nums
   * @return
   */
  private static int calNumWithRecord(int change, int nums[]) {
    int mem[] = new int[change + 1];
    //所有初始化为-2
    for (int i = 0; i < mem.length; i++) {
      mem[i] = -2;
    }
    return helper(change, nums, mem);
  }

  private static int helper(int change, int nums[], int mem[]) {
    if (change == 0) {
      return 0;
    }
    //这边相当于使用了备忘录
    if (mem[change] != -2) {
      return mem[change];
    }
    int result = Integer.MAX_VALUE;
    for (int num : nums) {
      //金额不可达
      if (change - num < 0) {
        continue;
      }
      int subPro = helper(change - num, nums, mem);
      if (subPro == -1) {
        continue;
      }
      result = Math.min(result, subPro + 1);
    }
    //记录本轮答案
    mem[change] = (result == Integer.MAX_VALUE) ? -1 : result;
    return mem[change];
  }

  /**
   * 动态规划的解法，用到了DP表，这边就是一个数组
   * 非常重要的就是写好状态转移方程
   * @param change
   * @param nums
   * @return
   */
  private static int calNumWithDP(int change, int nums[]) {
    int dp[] = new int[change + 1];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      //初始化为change + 1，所以返回结果比较的是change + 1，change + 1应该就是所有组合中的最大值了，不要初始化为Integer.MAX_VALUE
      dp[i] = change + 1;
    }
    for (int i = 0; i < dp.length; i++) {
      //内层循环求所有子问题+1的最小值
      for (int num : nums) {
        if (i - num < 0) {
          continue;
        }
        dp[i] = Math.min(dp[i], 1 + dp[i - num]);
      }
    }
    return (dp[change] == change + 1) ? -1 : dp[change];
  }

}
