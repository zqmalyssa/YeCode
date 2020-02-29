package com.qiming.algorithm;

/**
 * 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 思路：两次翻转，先翻转整个句子，再翻转每个单词，细节是处理空格
 *
 */
public class ReverseSentence {

  public static void main(String[] args) {

    String s = "a good   example";

  }

  public String reverseWords(String s) {

    String str = s.trim();
    if (str.equals("")){
      return "";
    }
    //中间有多个空格的分法
    String[] strList = reverse(str).split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<strList.length; i++){
      sb.append(reverse(strList[i]));
      if(i!=strList.length-1){
        sb.append(" ");
      }
    }
    return sb.toString();

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
