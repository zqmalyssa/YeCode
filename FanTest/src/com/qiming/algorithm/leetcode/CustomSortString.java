package com.qiming.algorithm.leetcode;

import java.util.LinkedHashMap;

/**
 * 自定义字符串排序
 *
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。S 已经根据某种规则进行了排序。
   * 我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。返回任意一种符合条件的字符串T。
 *
 * 输入: S = "cba"  T = "abcd"   输出: "cbad"
 *
 * 解释: S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a". 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 *
 * 注意: S的最大长度为26，其中没有重复的字符。 T的最大长度为200。 S和T只包含小写字符。
 *
 * 思路 个人思路，用linkedhashmap，即排序，又有字符的key和出现的次数，然后剩余没有的往char的数组后面放就行了
 *
 * 另外 StringBuilder可以append字符，然后再toString()转成字符串
 *
 */
public class CustomSortString {

  public static void main(String[] args) {

    String S = "cba";
    String T = "abcd";

    System.out.println(new CustomSortString().customSortString(S, T));

  }

  public String customSortString(String S, String T) {

    if (S == null || S.length() == 0) {
      return T;
    }

    if (T == null) {
      return null;
    }

    //key和次数，自带顺序
    LinkedHashMap<Character, Integer> map = new LinkedHashMap();
    for (int i = 0; i < S.length(); i++) {
      char a = S.charAt(i);
      map.put(a, 0);
    }

    int len = T.length();
    char[] chars = new char[len];
    int right = T.length() - 1;
    for (int i = 0; i < len; i++) {
      char tmp = T.charAt(i);
      if (map.containsKey(tmp)) {
        //说明有这个值，次数加1
        map.put(tmp, map.get(tmp) + 1);
      } else {
        //说明没有这个值，放到结尾
        chars[right] = tmp;
        right--;
      }
    }
    int begin = 0;
    for (Character character : map.keySet()) {
      int size = map.get(character);
      for (int i = begin; i < begin + size; i++) {
        chars[i] = character;
      }
      begin = begin + size;
    }
    return String.valueOf(chars);
  }

}
