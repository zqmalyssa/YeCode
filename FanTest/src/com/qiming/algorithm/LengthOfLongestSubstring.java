package com.qiming.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 思路：先不考虑暴力的解法了，第一个是正常的滑动窗口，第二个是优化的滑动窗口，第三个是代替了Map的滑动，都掌握一下，具体看代码里
 *
 */
public class LengthOfLongestSubstring {

  public int lengthOfLongestSubstring(String s) {

    /**
     * 正常的滑动窗口
     * 因为hashset中contains方法是O(1)的，所以要用hashset去做滑动窗口
     */
//    int n = s.length();
//    Set<Character> set = new HashSet<>();
//    //向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i开头。
//    // 如果我们对所有的 i这样做，就可以得到答案。
//    int ans = 0, i = 0, j = 0;
//    while (i < n && j < n) {
//      if (!set.contains(s.charAt(j))) {
//        set.add(s.charAt(j++));
//        ans = Math.max(ans, j - i); //j加完后的
//      } else {
//        set.remove(s.charAt(i++)); //从头开始移除元素
//      }
//    }
//    return ans;

    //这个部够好，最糟糕的情况下每个字符会被i和j访问两次 aaaa的情况

    /**
     * 优化的滑动窗口
     * 上述的步骤最多需要执行2n个步骤，事实上，可以优化成n步骤
     */
    //定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
//    int n = s.length(), ans = 0;
//    Map<Character, Integer> map = new HashMap();
//    for (int j = 0, i = 0; j < n; j++) {
//      //注意这里的i是最近的一个重复点，而且这个i不是以0开头的
//      if (map.containsKey(s.charAt(j))) {
//        i = Math.max(map.get(s.charAt(j)), i);
//      }
//      ans = Math.max(ans, j - i + 1);
//      //注意这边的put是j+1，所以0对应的是1
//      map.put(s.charAt(j), j + 1);
//    }
//    return ans;

    /**
     * 再优化
     * 在字符集较小的时候，用数组去替代上面的hashmap，也能起到效果
     */
    int n = s.length(), ans = 0;
    int []index = new int[128];
    for (int j = 0, i = 0; j < n; j++) {
      //这里没有判断其实是默认值为0而已
      i = Math.max(index[s.charAt(j)], i);
      ans = Math.max(ans, j-i+1);
      index[s.charAt(j)] = j + 1;
    }
    return ans;
  }

}
