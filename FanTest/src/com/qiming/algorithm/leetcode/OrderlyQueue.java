package com.qiming.algorithm.leetcode;

import java.util.Arrays;

/**
 * 有序队列
 *
 * 给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
 * 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
 *
 * 提示：1、 1 <= K <= S.length <= 1000  2、 S 只由小写字母组成。
 *
 *
 * 思路：当 K = 1 时，每次操作只能将第一个字符移动到末尾，因此字符串 S 可以看成一个头尾相连的环。如果 S 的长度为 NN，我们只需要找出这 NN 个位置中字典序最小的字符串即可。
 * 当 K = 2 时，可以发现，我们能够交换字符串中任意两个相邻的字母。具体地，设字符串 S 为 S[1], S[2], ..., S[i], S[i + 1], ..., S[N]，我们需要交换 S[i] 和 S[j]。
 * 首先我们依次将 S[i] 之前的所有字符依次移到末尾，得到S[i], S[i + 1], ..., S[N], S[1], S[2], ..., S[i - 1]，随后我们先将 S[i + 1] 移到末尾，再将 S[i] 移到末尾，得到
 * S[i + 2], ..., S[N], S[1], S[2], ..., S[i - 1], S[i + 1], S[i]，最后将 S[i + 1] 之后的所有字符依次移到末尾，得到
 * S[1], S[2], ..., S[i - 1], S[i + 1], S[i], S[i + 2], ..., S[N]，这样就交换了 S[i] 和 S[i + 1]，而没有改变其余字符的位置。
 * 当我们可以交换任意两个相邻的字母后，就可以使用冒泡排序的方法，仅通过交换相邻两个字母，使得字符串变得有序。因此当 K = 2 时，我们可以将字符串移动得到最小的字典序。
 * 当 K > 2 时，我们可以完成 K = 2 时的所有操作。
 *
 *
 */
public class OrderlyQueue {

  public static void main(String[] args) {
    String s = "baaca";
    System.out.println(new OrderlyQueue().orderlyQueue(s, 1));
  }

  public String orderlyQueue(String S, int K) {
    if (K == 1) {
      String ans = S;
      for (int i = 0; i < S.length(); ++i) {
        String T = S.substring(i) + S.substring(0, i);
        if (T.compareTo(ans) < 0) ans = T;
      }
      return ans;
    } else {
      char[] ca = S.toCharArray();
      Arrays.sort(ca);
      return new String(ca);
    }
  }

}
