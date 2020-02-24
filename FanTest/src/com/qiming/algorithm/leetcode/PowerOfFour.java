package com.qiming.algorithm.leetcode;

/**
 * 4的幂
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 思路：如何看一个数是否是2的幂，x > 0 and x & (x - 1) == 0，位运算法，先检查num是否是2的幂，现在的问题是区分 2 的偶数幂（当 xx 是 4 的幂时）和 2 的奇数幂（当 xx 不是 4 的幂时）。
 * 在二进制表示中，这两种情况都只有一位为 1，其余为 0。因此 4 的幂与数字 (101010...10)相与会得到0，(101010...10)用16进制表示是(0xaaaaaaaa)
 * 2

 *
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 */
public class PowerOfFour {

  public static void main(String[] args) {
    System.out.println(new PowerOfFour().isPowerOfFour(1073741824));
  }

  public boolean isPowerOfFour(int num) {

//    if (num <= 0) {
//      return false;
//    }
//
//    int b = 1;
//    //这边要是16，不然最后一次就进不来了
//    for (int i = 0; i < 16; i++) {
//      if ((num & 2147483647) == b) {
//        return true;
//      } else {
//        b = b << 2;
//      }
//    }
//
//    return false;

    /**
     * 非O(1)的解法
     */
//    if (num == 0) return false;
//    while (num % 4 == 0) num /= 4;
//    return num == 1;

    /**
     * 位运算解法
     */
    return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);

  }

}
