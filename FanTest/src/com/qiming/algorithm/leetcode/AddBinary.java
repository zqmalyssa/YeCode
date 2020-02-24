package com.qiming.algorithm.leetcode;

import java.math.BigInteger;

/**
 * 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1: 输入: a = "11", b = "1"  输出: "100"
 *
 * 思路：先转换程10进制求和，再转换程2进制，还有一种就是逐位运算了，XOR 操作得到两个数字无进位相加的结果。进位和两个数字与（&）操作结果左移一位对应。
 * 现在问题被简化为：首先计算两个数字的无进位相加结果和进位，然后计算无进位相加结果与进位之和。同理求和问题又可以转换成上一步，直到进位为 0 结束。
 *
 * 把 a 和 b 转换成整型数字 xx 和 yy，xx 保存结果，yy 保存进位。当进位不为 0：y != 0：计算当前 xx 和 yy 的无进位相加结果：answer = x^y。
 * 计算当前 x 和 y 的进位：carry = (x & y) << 1。完成本次循环，更新 x = answer，y = carry。
 *
 * 但是这两个运算或多或少有点问题，如果01串非常长，那么Integer根本也包不下，BigInteger也可能有解析问题，那就纯位运算呢？？
 *
 *
 *
 */
public class AddBinary {

  public static void main(String[] args) {
      char a = 1;
      char b = 2;
    System.out.println(a+b);
  }

  public String addBinary(String a, String b) {

    //这个集合包有点骚
//    return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
//    BigInteger x = new BigInteger(a, 2);
//    BigInteger y = new BigInteger(b, 2);
//    BigInteger zero = new BigInteger("0", 2);
//    BigInteger carry, answer;
//    while (y.compareTo(zero) != 0) {
//      answer = x.xor(y);
//      carry = x.and(y).shiftLeft(1);
//      x = answer;
//      y = carry;
//    }
//    return x.toString(2);

    int n = a.length(), m = b.length();
    if (n < m) return addBinary(b, a);
    int L = Math.max(n, m);

    StringBuilder sb = new StringBuilder();
    int carry = 0, j = m - 1;
    for(int i = L - 1; i > -1; --i) {
      if (a.charAt(i) == '1') ++carry;
      if (j > -1 && b.charAt(j--) == '1') ++carry;

      if (carry % 2 == 1) sb.append('1');
      else sb.append('0');

      carry /= 2;
    }
    if (carry == 1) sb.append('1');
    sb.reverse();

    return sb.toString();


  }

}
