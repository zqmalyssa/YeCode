package com.qiming.algorithm;

import java.util.Scanner;

/**
 * N皇后问题，在4*4或者8*8的棋盘上摆放皇后，使得它们之间不会被互相吃掉
 *
 * 思路是采用回溯法，回溯算法将解空间看作一定的结构，通常为树形结构，一个解对应于树中的一片树叶。算法从树根（即初始状态出发），尝试所有可能到达的结点。
 * 当不能前行时就后退一步或若干步，再从另一个结点开始继续搜索，直到尝试完所有的结点。也可以用走迷宫的方式去理解回溯，设想把你放在一个迷宫里，想要走出迷宫，
 * 最直接的办法是什么呢？没错，试。先选一条路走起，走不通就往回退尝试别的路，走不通继续往回退，直到走遍所有的路，并且在走的过程中你可以记录所有能走出迷宫的路线
 */
public class NQueen {

  private static int totalNum = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int c[] = new int[n];
    queen(0, c, n);
    System.out.println(totalNum);
  }

  /**
   * 这个函数是用来摆放第row行中的皇后，用c[i]记录第i行的皇后放置的位置j列
   * @param row
   * @param c
   * @param n
   */
  private static void queen(int row, int c[], int n) {
    if (row == n) {
      //当row等于n的时候说明皇后已经全部摆放完毕
      for (int i = 0; i < n; i++) {
        System.out.print(c[i] + " ");
      }
      System.out.println("\n");
      totalNum++;
    } else {
      //皇后还没有摆完
      //遍历所有的列，看row行皇后可以放在第几列
      for (int col = 0; col < n; col++) {
        //要更新数组
        c[row] = col;
        //如果可以放在row行col列则继续摆放下一行
        if (isOk(c, row)) {
          queen(row + 1, c, n);
        }
        //如果循环了所有的列都不能摆放，则会回溯到前一层函数改变上一行皇后的摆放
      }
    }
  }

  /**
   * 判断皇后能不能摆放到这个位置
   * 也就是row行皇后不能和任意之前的皇后在列上 / 和 \方向上一致
   * @param c
   * @param row
   * @return
   */
  private static boolean isOk(int c[], int row) {
    for (int i = 0; i < row; i++) {
      //第row行皇后不能和任意之前的皇后在同一列或 \方向或 / 方向
      if (c[i] == c[row] || c[row]-row == c[i]-i || c[row]+row == c[i]+i) {
        return false;
      }
    }
    return true;
  }


}
