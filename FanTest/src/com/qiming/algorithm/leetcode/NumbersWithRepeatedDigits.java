package com.qiming.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 至少有 1 位重复的数字
 *
 * 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
 *
 * 示例 2 输入：100 输出：10 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100
 *
 * 提示： 1 <= N <= 10^9
 *
 * 思路： 本题的思路是将其转换为数位DP，利用排列组合完成解题，题目需要求数字N有多少个重复的数字，可以将其转换为求数字N有多少个不重复的数字，因为求不重复的数字可以更好地使用排列组合来求解
 *
 * 现在我们的重心来到要怎么将这个数字分解成可以按一定规律计算其所有不重复数位的排列组合，总体的思路是：设剩下的位置为i，剩下的数字为j，则不重复数字是在每一位依次填入与前几位不同的数字
 *
 * 即选取剩下的j个数字填入剩下的i个位置，即有A(j, i)种可能，最后将其累加就是不重复数字个数，实际遍历中，我们只需要剩下的位置i这个变量，设数字N的位数为k，则剩下的数字j=10-(k-i)，一共10个数字呗
 *
 * 对于以上思路，我们还可以分为以下两种情况，第一种是高位带0，第二种是高位不带0，我们知道数学中0这个数字比较特别，高位数为0即等于没有高位数，比如0096就是数字96，这个数字尽管两个0重复了
 *
 * 但是这两个0属于高位，所以0096这个数字不是重复数字，即第一种情况允许高位的0可以重复，使用第一种情况求位数小于k的不重复数字的个数：因为最高位总是为0，因此一开始剩下的数字j总是为9个（1-9）
 *
 * 然后剩下的低位可选的数字总共有A(10-1,i)，使用第二种情况求位数为k的不重复数字的个数：一开始剩下的数字j受数字N每位上的数字影响，设N的当前位的数字为n，则j<=n，然后剩下的低位可选的数字总共有A(10-(k-i),i)
 *
 * 第一种情况：
 *
 * 4th 3th 2th 1th total
 *  0   0   0  1-9 9xA(9,0)
 *  0   0  1-9 0-9 9xA(9,1)
 *  0  1-9 0-9 0-9 9xA(9,2)
 *
 * 第二种情况：
 *
 * 4th 3th 2th 1th total
 * 1-2 0-9 0-9 0-9 2xA(9,3)
 *  3  0-4 0-9 0-9 5xA(8,2)
 *  3   5  0-5 0-9 6xA(7,1)
 *  3   5   6  0-1 2xA(6,0)
 *  3   5   6   2  1
 *
 * 注：total为理想的总数，最后还需要将重复的数字剔除，比如第二种情况的第二行中，如果遍历到了33xx，则后面的xx不需要再计算，因为高位的33已经使这个数字变为了重复数字，循环可以直接break掉
 *
 * 比较特殊的情况还有第二种情况的第一行，注意高位是从1开始，因为0的情况在第一种情况的最后一行已经考虑；还有第二种情况的最后一行，如果前三个高位的数字不重复，并且最后要填入的2也与前面数字不重复，
 *
 * 则数字N本身也是一个不重复数字
 *
 */
public class NumbersWithRepeatedDigits {

  public int numDupDigitsAtMostN(int N) {
    return N - dp(N);
  }

  public int dp(int n) {
    List<Integer> digits = new ArrayList<>();
    while (n > 0) {
      digits.add(n % 10);
      n /= 10;
    }
    int k = digits.size();

    int[] used = new int[10];
    int total = 0;

    for (int i = 1; i < k; i++) {
      total += 9 * A(9, i - 1);
    }

    for (int i = k - 1; i >= 0; i--) {
      int num = digits.get(i);

      for (int j = i == k - 1 ? 1 : 0; j < num; j++) {
        if (used[j] != 0) {
          continue;
        }
        total += A(10 - (k - i), i);
      }

      if (++used[num] > 1) {
        break;
      }

      if (i == 0) {
        total += 1;
      }
    }
    return total;
  }

  public int fact(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    return n * fact(n - 1);
  }

  public int A(int m, int n) {
    return fact(m) / fact(m - n);
  }


}
