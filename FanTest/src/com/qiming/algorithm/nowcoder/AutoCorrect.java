package com.qiming.algorithm.nowcoder;

import java.util.Scanner;

/**
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 * 写出一个校准器
 * 思路是使用双指针，并借助StringBuilder或者StringBuffer，其中一个慢指针，一个快指针，k慢的在并不满足规则1,2时随着快i的增加而增加
 * 当满足规则时停止移动，处理开始
 */

public class AutoCorrect {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
//    while(true) { //nowcoder中不需要while(true)，一次性的
    int N = Integer.parseInt(scanner.nextLine());
    String[] s = new String[N];
    for (int i = 0; i < N; i++) {
      s[i] = scanner.nextLine();
      s[i] = autoCorrect(s[i]);
    }
    for (int i = 0; i < N; i++) {
      System.out.println(s[i]);
    }

//    }
  }

  private static String autoCorrect(String source) {
    char[] chars = source.toCharArray();
    StringBuffer sb = new StringBuffer();
    int k = 0;
    for (int i = 0; i < chars.length; i++) {
      chars[k] = chars[i];
      sb.append(chars[k]);
      k++;
      //先满足规则1
      if (k >= 3 && chars[k-3] == chars[k-2] && chars[k-2] == chars[k-1]) {
        sb.deleteCharAt(k-1);
        k--;
      }
      //再满足规则2
      if (k >= 4 && chars[k-4] == chars[k-3] && chars[k-2] == chars[k-1]) {
        sb.deleteCharAt(k-1);
        k--;
      }
    }
    return String.valueOf(sb);
  }

  private static String del(String s, int i) {
    return s.substring(0, i) + s.substring(i+1);
  }
}
