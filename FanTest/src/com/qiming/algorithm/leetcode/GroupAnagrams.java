package com.qiming.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明： 所有输入均为小写字母。不考虑答案输出的顺序。
 *
 * 思路 自己的思路，用小写字母的出现+次数的拼接作为map的key，然后值就是存储的String
 *
 * 其他思路 当且仅当它们的排序字符串相等时，两个字符串是字母异位词
 *
 */
public class GroupAnagrams {

  public static void main(String[] args) {
    String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> result = new GroupAnagrams().groupAnagrams(s);
    for (List<String> strings : result) {
      for (String string : strings) {
        System.out.print(string + " ");
      }
      System.out.println("\n");
    }
  }

  public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> result = new LinkedList<>();

    if (strs.length == 0) {
      return result;
    }
    HashMap<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];
      char[] chars = s.toCharArray();
      int[] charCount = new int[26];
      for (int j = 0; j < chars.length; j++) {
        charCount[chars[j] - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < charCount.length; j++) {
        if (charCount[j] != 0) {
          //说明有数量
          sb.append(j);
          sb.append('_');
          sb.append(charCount[j]);
          sb.append('_');
        }
      }
      String key = sb.toString();
      if (map.containsKey(key)) {
        List<String> oldList = map.get(key);
        oldList.add(s);
      } else {
        List<String> newList = new LinkedList<>();
        newList.add(s);
        map.put(key, newList);
      }
    }

    for (String s : map.keySet()) {
      result.add(map.get(s));
    }
    return result;

//    当且仅当它们的排序字符串相等时，两个字符串是字母异位词
//    if (strs.length == 0) return new ArrayList();
//    Map<String, List> ans = new HashMap<String, List>();
//    for (String s : strs) {
//      char[] ca = s.toCharArray();
//      Arrays.sort(ca);
//      String key = String.valueOf(ca);
//      if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//      ans.get(key).add(s);
//    }
//    return new ArrayList(ans.values());

  }

}
