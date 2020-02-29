package com.qiming.algorithm;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * s = "abaccdeff"  返回 "b"  s = ""  返回 " "  0 <= s 的长度 <= 50000
 *
 * 思路：用linkedhashmap，即记录次数，又记录顺序，也可以用辅助数组，两次扫描
 *
 */
public class FirestNotRepeatingChar {

  public char firstUniqChar(String s) {

    /**
     * 这是linkedhashmap的写法
     */
//    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//    for (int i = 0; i < s.length(); i++) {
//      char tmp = s.charAt(i);
//      //这边是不等于null
//      if (map.get(tmp) != null) {
//        map.put(tmp, map.get(tmp) + 1);
//      } else {
//        map.put(tmp, 1);
//      }
//    }
//
//    for (Character character : map.keySet()) {
//      if (map.get(character) == 1) {
//        return character;
//      }
//    }
//
//    return ' ';

    int index[] = new int[26];
    for (int i = 0; i < s.length(); i++) {
      index[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (index[s.charAt(i) - 'a'] == 1) {
        return s.charAt(i);
      }
    }

    return ' ';
  }

}
