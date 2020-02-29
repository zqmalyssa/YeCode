package com.qiming.algorithm;

/**
 * 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 思路：这个其实是二分查找法的演化，旋转后要充分利用性质，分成了两个子数组，其中第一个的值都要比第二个大，且都排序，第一个指针指向第一个元素，第二个指针指向最后，
 * 取中间值进行比较，更改一二指针，但是这边有个特殊情况就是[1,0,1,1,1]和[1,1,1,0,1]都是[0,1,1,1,1]的旋转，但是不知道mid是落在第一区间还是第二区间了，需要顺序查找
 *
 */
public class FindMinOfArray {

  public int minArray(int[] numbers) {

    if (numbers.length == 0) {
      return -1;
    }

    int index1 = 0;
    int index2 = numbers.length - 1;
    int indexMid = index1;

    while (numbers[index1] >= numbers[index2]) {

      if (index2 - index1 == 1) {
        indexMid = index2;
        break;
      }

      indexMid = (index1 + index2) / 2;
      //如果下标index1，index2和indexMid都相等，则顺序查找了
      if (numbers[index1] == numbers[index2] && numbers[index2] == numbers[indexMid]) {
        return MinInOrder(numbers, index1, index2);
      }

      if (numbers[indexMid] >= numbers[index1]) {
        index1 = indexMid;
      } else if (numbers[indexMid] <= numbers[index2]) {
        index2 = indexMid;
      }

    }
    return numbers[indexMid];
  }

  private int MinInOrder(int[] nums, int index1, int index2) {
    int result = nums[index1];
    for (int i = index1 + 1; i <= index2 ; i++) {
      if (result > nums[i]) {
        result = nums[i];
      }
    }
    return result;
  }

}
