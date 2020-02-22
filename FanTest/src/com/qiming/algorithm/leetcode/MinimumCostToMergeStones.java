package com.qiming.algorithm.leetcode;

/**
 * 合并石头的最低成本
 *
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 *
 * 输入：stones = [3,2,4,1], K = 3 输出：-1
 *
 * 输入：stones = [3,5,1,2,6], K = 3 输出：25
 *
 * Impossible to do search, Greedy doesn't work either. DP is the only approach
 * Non-overlapping subproblems  dp[i][j][k] := min cost to merge A[i] - A[j] into k piles
 * Init: dp[i][i][1] = 0 # no cost to merge one into one
 *
 * dp[i][j][k] = min(dp[i][m][1] + dp[m+1][k-1]), i <= m < j, 2 <=k <=K
 * dp[i][j][1] = dp[i][j][k] + sum(A[i]~A[j])
 *
 * ans: dp[0][n-1][1] merge the whole array into one
 */

public class MinimumCostToMergeStones {

  public static void main(String[] args) {
    System.out.println(-1 % 2);
  }

  public int mergeStones(int[] stones, int K) {
    int size = stones.length;
    int mod = (size - K) % (K-1);
    int maxInt = Integer.MAX_VALUE;
    if (mod != 0) {
      return -1;
    }

    //对应sum(A[i]~A[j]) sums[1]表示到从1元素大1元素，sums[2]表示从1元素到2元素的和
    int []sums = new int[size+1];
    for (int i = 0; i < size; i++) {
      sums[i + 1] = sums[i] + stones[i];
    }
    //dp表初始化为最大值，因为要求的是min
    int dp[][][] = new int[size][size][K+1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        for (int k = 0; k < dp[i][j].length; k++) {
          dp[i][j][k] = maxInt;
        }
      }
    }

    //这是上面的init
    for (int i = 0; i < size; i++) {
      dp[i][i][1] = 0;
    }

    //转换动态方程到代码
    for (int i = 2; i <= size; i++) {  //subproblem length 相当于限制，不能高于这个数了
      for (int j = 0; j <= size - i; j++) {  //start
        int m = j + i - 1; //end
        for (int k = 2; k <= K ; k++) { //piles
          for (int n = j; n < m; n += K-1) {  //split point
            dp[j][m][k] = Math.min(dp[j][m][k], dp[j][n][1] + dp[n+1][m][k-1]);
          }
        }
        dp[j][m][1] = dp[j][m][K] + sums[m+1] - sums[j]; //根据前面的意思这边就减一下，就是sum(A[j]~A[m])
      }
    }
    return dp[0][size-1][1];
  }

}
