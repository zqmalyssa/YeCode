package com.qiming.algorithm;

/**
 * 把字符串转换成整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
 * 作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略
 * 它们对于函数不应该造成影响。注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。在任何情况下，
 * 若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：假设我们的环境只能存储32位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回 INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 * 示例 1: 输入: "42" 输出: 42 示例 2: 输入: "   -42" 输出: -42 输入: "4193 with words" 输出: 4193 输入: "words and 987" 输出: 0 输入: "-91283472332" 输出: -2147483648
 *
 * 思路：正常一步步往下写，需要有各种判断
 *
 *
 */
public class StringToInteger {

  public int strToInt(String str) {

    int result = 0;
    char[] chars = str.toCharArray();
    int len = str.length();
    int zf = 1;
    int i = 0;
    int pop = 0;
    for (; i < len; i++) {
      if (chars[i] == ' ') {
        continue;
      } else {

        if (chars[i] == '-') {
          zf = -1;
          i++; //需要i++，因为后面break了，不会跑上面的i++了
          break;
        }

        if (chars[i] == '+') {
          i++; //需要i++，因为后面break了，不会跑上面的i++了
          break;
        }

        if (chars[i] < '0' || chars[i] > '9') {
          return 0;
        } else {
          break;
        }

      }
    }

    if (i == len) {
      return 0;
    }

    //从找到的数开始
    for (; i < len; i++) {

      if (chars[i] < '0' || chars[i] > '9') {
        return result;
      }
      //字符转换成数字的标准做法，减去48
      pop = (chars[i] - 48) * zf;
      //边界条件，要除以10计算，因为pop是新的一位数字了
      if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
        return Integer.MAX_VALUE;
      }

      if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
        return Integer.MIN_VALUE;
      }

      result = result * 10 + pop;

    }

    return result;

  }

}
