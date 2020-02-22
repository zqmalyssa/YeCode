package com.qiming.algorithm.al;
import java.util.HashSet;
import java.util.Scanner;

/**
 * longest substring without repeating characters.
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestStringLength {

  public static void main(String[] args) {
    //输入测试
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      String input = in.nextLine();
      System.out.println(LengthOfLongestSubstring(input));
    }
  }

  public static int LengthOfLongestSubstring(String str) {
//    int n = str.length();
//    int result = 0;
//    //做一个字符表
//    int[] index = new int[128];
//    //利用滑动窗口计算
//    for (int j = 0, i = 0; j < n; j++) {
//      i = Math.max(index[str.charAt(j)], i);
//      result = Math.max(result, j - i + 1);
//      index[str.charAt(j)] = j + 1;
//    }
//    return result;

        //空字串返回0
    int result = 0;
    int strLength = str.length();
    int i = 0, j = 0;

    HashSet<String> hashSet = new HashSet<String>();

    while (i < strLength && j < strLength) {
      String oneStr = str.substring(j, j + 1);
      if (!hashSet.contains(oneStr)) {
        hashSet.add(oneStr);
        j++;
        result = Math.max(result, j-i);
      } else {
        String oneStrI = str.substring(i, i + 1);
        hashSet.remove(oneStrI);
        i++;
      }
    }
    return result;
  }

}
