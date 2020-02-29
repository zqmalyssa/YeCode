package com.qiming.algorithm;

/**
 * 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 输入: s = "abcdefg", k = 2 输出: "cdefgab"
 *
 * 思路：同样是翻转，但是我们按两个部分翻转，这两个部分由k间隔，然后对整个字符串翻转，一共翻3次
 *
 */
public class LeftRotateString {

  public String reverseLeftWords(String s, int n) {

    String s1 = reverse(s.substring(0, n));
    String s2 = reverse(s.substring(n, s.length()));
    return reverse(s1 + s2);


  }

  private String reverse(String s){
    StringBuilder sb = new StringBuilder(s);
    int i=0, j=s.length()-1;
    while(i<j){
      char temp = sb.charAt(i);
      sb.setCharAt(i, sb.charAt(j));
      sb.setCharAt(j, temp);
      i++;
      j--;
    }
    return sb.toString();
  }

}
