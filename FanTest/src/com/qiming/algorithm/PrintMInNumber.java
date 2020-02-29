package com.qiming.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 2: 输入: [3,30,34,5,9] 输出: "3033459"
 *
 * 思路：自建一个比较器，比较String的大小，int型拼接可能有溢出风险
 *
 */
public class PrintMInNumber {

  public String minNumber(int[] nums) {

    //得到一个String类型数组，形似nums
    String[] strNumbers = new String[nums.length];
    for(int i = 0; i < nums.length; i++) {
      strNumbers[i] = String.valueOf(nums[i]);
    }
    //排序。（传入一个比较器对象）
    Arrays.sort(strNumbers, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o1 + o2).compareTo(o2 + o1);//升序，交换参数就是降序
      }
    });
    //将该字符串数组元素拼接起来
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < strNumbers.length; i++) {
      sb.append(strNumbers[i]);
    }
    return sb.toString();
  }

}
