package com.qiming.algorithm;

/**
 * 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1 输出：3  1 <= n,m <= 100  0 <= k <= 20
 *
 * 思路：变体的回溯法和DFS结合
 *
 */
public class RobotMovingCount {

  private int count = 0;

  public int movingCount(int m, int n, int k) {

    boolean[][] flag = new boolean[m][n];
    for (int i = 0; i < flag.length; i++) {
      for (int j = 0; j < flag[0].length; j++) {
        flag[i][j] = false;
      }
    }
    dfs(0, 0, k, m, n, flag);
    return count;

  }

  private void dfs(int row, int column, int k, int m, int n, boolean[][] flag) {

    if (row < 0 || row >= m || column < 0 || column >= n || !isSuit(row, column, k) || flag[row][column]) {
      return;
    }

    count++;
    flag[row][column] = true;
    dfs(row + 1, column, k, m, n, flag);
    dfs(row - 1, column, k, m, n, flag);
    dfs(row, column + 1, k, m, n, flag);
    dfs(row, column - 1, k, m, n, flag);

    //访问过了就访问过了，不需要撤销，不像之前不能访问访问过的结点，上面已经判断了
//    flag[row][column] = false;
  }

  private boolean isSuit(int row, int column, int k) {

    int rowLeft = 0;
    int columnLeft = 0;
    int bitSum = 0;
    //1, 0 是不是不成立的话用&&
    while (row != 0 || column != 0) {
      rowLeft = row % 10;
      columnLeft = column % 10;
      bitSum += rowLeft + columnLeft;
      row = row / 10;
      column = column / 10;
    }
    if (bitSum <= k) {
      return true;
    } else {
      return false;
    }

  }

  public static void main(String[] args) {

//    new RobotMovingCount().isSuit(1, 0, 18);

//    new RobotMovingCount().movingCount(3, 1, 0);

    new RobotMovingCount().movingCount(3, 2, 17);

  }

}
