package com.qiming.HW;

import java.util.Scanner;

/**
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 思路就是String的使用，注意这里面不需要一个测试用例有多组数据
 */
public class HandleTwoString {

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    String[] str1 = handle(s1);
    String[] str2 = handle(s2);
    if (str1 != null) {
      for (int i = 0; i < str1.length; i++) {
        System.out.println(str1[i]);
      }
    }
    if (str2 != null) {
      for (int i = 0; i < str2.length; i++) {
        System.out.println(str2[i]);
      }
    }
  }

  /**
   * 这个方法不好
   * @param str
   * @return
   */
  private static String[] handle(String str) {
    if (str == null || str.equals("")) {
      return null;
    }

    char[] chars = str.toCharArray();
    if (chars.length % 8 == 0) {
      int arraynum = chars.length / 8;
      String[] s = new String[arraynum];
      for (int i = 0; i < arraynum; i++) {
        char[] temp = new char[8];
        for (int j = 0 ; j < temp.length; j++) {
          temp[j] = chars[i*8+j];
        }
        s[i] = String.valueOf(temp);
      }
      return s;
    } else {
      int arraynum = chars.length / 8 + 1;
      int havenum = chars.length % 8;
      String[] s = new String[arraynum];
      for (int i = 0; i < arraynum - 1; i++) {
        char[] temp = new char[8];
        for (int j = 0 ; j < temp.length; j++) {
          temp[j] = chars[i*8+j];
        }
        s[i] = String.valueOf(temp);
      }
      char[] last = new char[8];;
      for (int i = 0; i < havenum; i++) {
        last[i] = chars[(arraynum-1) * 8 + i];
      }
      for (int j = 7; j > havenum - 1; j--) {
        last[j] = '0';
      }
      //再补充最后的
      s[arraynum-1] = String.valueOf(last);
      return s;
    }
  }

  /**
   * 直接用字符串处理比较清晰
   * @param str
   * @return
   */
  private static String[] handleByString(String str) {
    if (str == null || str.equals("")) {
      return null;
    }

    int length = str.length();
    if (length % 8 == 0) {
      int arraynum = length / 8;
      String[] s = new String[arraynum];
      for (int i = 0; i < arraynum; i++) {
        s[i] = str.substring(i*8, i*8 + 8);
      }
      return s;
    } else {
      int arraynum = length / 8 + 1;
      int havanum = length % 8;
      String[] s = new String[arraynum];
      for (int i = 0; i < arraynum - 1; i++) {
        s[i] = str.substring(i*8, i*8 + 8);
      }
      //补充最后的
      s[arraynum-1] = str.substring(8*(arraynum-1), length);
      for (int i = 0; i < 8- havanum; i++) {
        s[arraynum-1] = s[arraynum-1] + "0";
      }
      return s;
    }
  }

}
