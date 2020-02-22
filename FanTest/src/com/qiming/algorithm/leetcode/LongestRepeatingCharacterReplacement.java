package com.qiming.algorithm.leetcode;

/**
 * 替换后的最长重复字符
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 字符串长度 和 k 不会超过 10^4。输入:s = "AABABBA", k = 1 输出: 4
 *
 * 思路 滑动窗口，和之前的LongestStringLength一个道理
 *
 * 当K>0时，子串的条件变成了允许我们变换子串中的K个字符使其变成一个连续子串，那么这个题的关键点就是我们如何判断一个字符串改变K个字符，能够变成一个连续串
 *
 * 如果当前字符串中的出现次数最多的字母个数+K大于串长度，那么这个串就是满足条件的
 *
 * 我们维护一个数组int[26]来存储当前窗口中各个字母的出现次数（注意当前窗口这个说法很重要），left表示窗口的左边界，right表示窗口右边界，窗口扩张：left不变，right++，窗口滑动：left++, right++
 *
 * charMax保存滑动窗口内相同字母出现次数的历史最大值，通过判断窗口宽度(right - left + 1)是否大于charMax + K来决定窗口是否做滑动，否则窗口就扩张，这个很关键
 *
 *
 */
public class LongestRepeatingCharacterReplacement {

  private int[] map = new int[26];

  public int characterReplacement(String s, int k) {
    if (s == null) {
      return 0;
    }
    char[] chars = s.toCharArray();
    int left = 0;
    int right = 0;
    int charMax = 0;
    for (right = 0; right < chars.length; right++) {
      int index = chars[right] - 'A';
      map[index]++;
      charMax = Math.max(charMax, map[index]);
      if (right - left + 1 > charMax + k) {
        //滑动，注意是当前窗口，所以有个map--
        map[chars[left] - 'A']--;
        left++;
      }
      //否则就是扩张
    }
    //最后就是返回窗口的长度
    return chars.length - left;

  }

}
