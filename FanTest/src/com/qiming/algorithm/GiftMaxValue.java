package com.qiming.algorithm;

import java.util.TreeSet;

/**
 * 礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
 * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 *
 * 输出: 12
 *
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物   0 < grid.length <= 200  0 < grid[0].length <= 200
 *
 * 思路：回溯法超时了，还是得要动态规划，dp[i][j]表示到达这个点的最大值，那么dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + grid[i][j]
 * 而初始值是dp[0][0] = grid[0][0] 还有 d[i][0] = d[i-1][0] + grid[i][0]  d[0][j] = d[0][j-1] + grid[0][j]
 *
 */
public class GiftMaxValue {

  private TreeSet<Integer> result = new TreeSet();
  private int sum;

  public static void main(String[] args) {

//    int test[][] = ({1,3,1},{1,5,1},{4,2,1});  //jekyll
//    int test1[][] = ({1,2},{5,6},{1,1});
//    int result = new GiftMaxValue().maxValue(test);
//    System.out.println(result);

  }

  public int maxValue(int[][] grid) {

//    dfs(0, 0, grid);
//    return result.last();

    int row = grid.length;
    int column = grid[0].length;

    int dp[][] = new int[row][column];

    dp[0][0] = grid[0][0];

    for (int i = 1; i < row; i++) {
      dp[i][0] = dp[i-1][0] + grid[i][0];
    }

    for (int i = 1; i < column; i++) {
      dp[0][i] = dp[0][i-1] + grid[0][i];
    }

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < column; j++) {
        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
      }
    }

    return dp[row-1][column-1];

  }


  private void dfs(int row, int column, int[][] grid) {

    if (row >= grid.length || column >= grid[0].length) {
      return;
    }

    if (row == grid.length - 1 && column == grid[0].length - 1) {
      //说明到最后了
      sum += grid[row][column];
      result.add(sum);
      sum -= grid[row][column];
      return;
    }

    sum += grid[row][column];

    dfs(row, column + 1, grid);
    dfs(row + 1, column, grid);

    sum -= grid[row][column];

  }

}
