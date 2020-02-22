package com.qiming.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证外星语词典
 *
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz" 输出：true 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz" 输出：false 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz" 输出：false 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * 1 <= words.length <= 100   1 <= words[i].length <= 20   order.length == 26   在 words[i] 和 order 中的所有字符都是英文小写字母。
 *
 * 思路：一开始同hashmap做词典，后来改成数组了
 *
 */
public class VerifyingAnAlienDictionary {

  public static void main(String[] args) {
//    String[] s = {"apple", "app"};
//    String order = "abcdefghijklmnopqrstuvwxyz";

    String[] s = {"hello","leetcode"};
    String order = "hlabcdefgijkmnopqrstuvwxyz";

    new VerifyingAnAlienDictionary().isAlienSorted(s, order);
  }

  public boolean isAlienSorted(String[] words, String order) {

    /**
     * 这个太耗时间，HashMap也不可取，还得用数组
     */
//    if (words.length == 1) {
//      return true;
//    }
//
//    Map<Character, Integer> index = new HashMap();
//    for (int i = 0; i < order.length(); i++) {
//      index.put(order.charAt(i), i);
//    }
//
//    for (int i = 0, j = 1; i < words.length - 1; i++, j++) {
//      if (compareTwoString(words[i], words[j], index) == 1) {
//        return false;
//      }
//    }
//
//    return true;

    if (words.length == 1) {
      return true;
    }

    //上数组
    int[] index = new int[26];
    for (int i = 0; i < order.length(); i++) {
      //这样就变成索引了
      index[order.charAt(i) - 'a'] = i; //i在index数组代表原a-z现在是第几位
    }


    for (int i = 0, j = 1; i < words.length - 1; i++, j++) {

      String s1 = words[i];
      String s2 = words[j];

      boolean breakFlag = false;
      for (int k = 0; k < Math.min(s1.length(), s2.length()); k++) {
        if (s1.charAt(k) != s2.charAt(k)) {
          if (index[s1.charAt(k) - 'a'] > index[s2.charAt(k) - 'a']) {
            return false;
          } else {
            //这个地方两种情况整不明白，就用一个flag
            breakFlag = true;
            break;
          }
        }
      }

      if (breakFlag) {
        continue;
      }
      if (s1.length() > s2.length()) {
        return false;
      }
    }

    return true;

  }

  private int compareTwoString(String s1, String s2, Map<Character, Integer> index) {
    int s1len = s1.length(), s2len = s2.length();
    int len = s1len >= s2len ? s2len : s1len;
    for (int i = 0; i < len; i++) {
      int tmp = index.get(s1.charAt(i)) - index.get(s2.charAt(i));
      if (tmp > 0) {
        return 1;
      } else if (tmp < 0) {
        return -1;
      }
    }
    if (s1len == s2len) {
      return 0;
    }

    return s1len > s2len ? 1 : -1;
  }


}
