package com.qiming.algorithm;

/**
 * n个骰子的点数
 *
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 输入: 1 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 思路：其实还是动态规划，想出状态转移方程，f(n,s)是n个骰子和为s的排列情况总数，那么其实f(n,s) = f(n-1, s-1) + f(n-1, s-2) + f(n-1, s-3) + f(n-1, s-4) + f(n-1, s-5) + f(n-1, s-6)
 * 因为下一个骰子的情况有6种，初始阶段的解是 n=1，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6) = 1
 *
 */
public class PrintProbability {

  public static void main(String[] args) {

    double[] res = new PrintProbability().twoSum(2);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i]);
    }


  }

  public double[] twoSum(int n) {

    int dp[][] = new int[n+1][6*n+1];
    double[] ans = new double[5*n+1];  //所有的范围是n到6n
    double all = Math.pow(6, n);  //这是所有的可能性
    for (int i = 1; i <= 6; i++) {
      dp[1][i] = 1;
    }

    for (int i = 1; i <= n ; i++) {  //骰子的个数
      for (int j = i; j <= 6*n; j++) { //总和大小
        for (int k = 1; k <= 6; k++) {
          //总和大于等于k值时，需要考虑前面的值，否则不需要
          dp[i][j] += j >= k ? dp[i-1][j-k] : 0;
          if (i==n) {
            ans[j-i] = dp[i][j] / all;
          }
        }
      }
    }
    return ans;
  }

}
