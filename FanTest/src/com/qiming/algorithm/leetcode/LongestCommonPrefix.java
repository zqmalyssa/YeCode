package com.qiming.algorithm.leetcode;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1: 输入: ["flower","flow","flight"] 输出: "fl"
 * 示例 2: 输入: ["dog","racecar","car"] 输出: ""
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 思路：水平垂直法，分治法，二分查找法
 *
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String s1[] = {"flower","flow","flight"};
    String s2 = "abcg";
    new LongestCommonPrefix().longestCommonPrefix(s1);
    System.out.println("flow".indexOf("flower"));
  }

  public String longestCommonPrefix(String[] strs) {
    /**
     * 水平扫描法
     */
//    if (strs.length == 0) return "";
//    String prefix = strs[0];
//    for (int i = 1; i < strs.length; i++)
//      //成为公共前缀了就会为0，公共前缀index必从0开始
//      while (strs[i].indexOf(prefix) != 0) {
//        //每次缩小一个字符。再检查
//        prefix = prefix.substring(0, prefix.length() - 1);
//        //字符没有了，说明就没有公共前缀了，直接返回""
//        if (prefix.isEmpty()) return "";
//      }
//    return prefix;
    /**
     * 竖直扫描，每个字符上的每一列
     */
//    if (strs == null || strs.length == 0) return "";
//    for (int i = 0; i < strs[0].length() ; i++){
//      char c = strs[0].charAt(i);
//      for (int j = 1; j < strs.length; j ++) {
//        //判断条件是到底了和字符不一样
//        if (i == strs[j].length() || strs[j].charAt(i) != c)
//          return strs[0].substring(0, i);
//      }
//    }
//    return strs[0];
    /**
     * 分治，将单词分组，分别计算LCP，再合起来计算LCP，用了递归，并将问题分解成了两个字符串的比较
     */
//    if (strs == null || strs.length == 0) return "";
//    return longestCommonPrefix(strs, 0 , strs.length - 1);
    /**
     * 二分查找法，应用二分查找法找到所有字符串的公共前缀的最大长度 L
     */
    if (strs == null || strs.length == 0)
      return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
      minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
      int middle = (low + high) / 2;
      if (isCommonPrefix(strs, middle))
        low = middle + 1;
      else
        high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);

  }

  /**
   * 分治法辅助函数
   * @param strs
   * @param l
   * @param r
   * @return
   */
  private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
      return strs[l];
    }
    else {
      int mid = (l + r)/2;
      String lcpLeft =   longestCommonPrefix(strs, l , mid);
      String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
      return commonPrefix(lcpLeft, lcpRight);
    }
  }

  String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
      if ( left.charAt(i) != right.charAt(i) )
        return left.substring(0, i);
    }
    return left.substring(0, min);
  }

  /**
   * 二分查找法辅助函数
   * @param strs
   * @param len
   * @return
   */
  private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
      if (!strs[i].startsWith(str1))
        return false;
    return true;
  }


}
