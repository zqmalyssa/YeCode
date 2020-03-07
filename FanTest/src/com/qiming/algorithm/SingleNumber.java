package com.qiming.algorithm;

/**
 * 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [3,4,3,3] 输出：4  输入：nums = [9,1,7,9,7,9,7] 输出：1
 *
 *
 * 思路：记录每一位不为0的数字出现的次数，如果出现的次数对3取模为1，则说明只出现一次的数字此位也是1，将这些位相加就得到结果了
 *
 */
public class SingleNumber {

  public static void main(String[] args) {

    int []nums = {3,4,3,3};
    new SingleNumber().singleNumber(nums);

  }

  public int singleNumber(int[] nums) {

    int ans = 0;
    int bit = 1;
    for (int i = 0; i < 32; i++) {
      int count = 0;
      for (int num : nums) {
        //这边是不等于0哦，与上有值就说明位数上是1，不是==1
        if ((num & bit) != 0) {
          count++;
        }
      }
      if (count % 3 == 1) {
        ans += bit;
      }
      bit <<= 1;
    }

    return ans;

  }

}
