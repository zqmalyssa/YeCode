package com.qiming.algorithm;

/**
 * 最小的K个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：输入：arr = [3,2,1], k = 2  输出：[1,2] 或者 [2,1]
 * 示例 2：输入：arr = [0,1,2,1], k = 1 输出：[0]
 *
 * 思路：这要看这个数组可否修改，如果可以修改，就可以借鉴partition的思路（排序不算答案了。。），比第k个数字小的数字放到数组的左边，比第k个数字大的数字放到数组的右边，那么数组中
 * 左边的k个数字就是最小的k个数字
 *
 * 还有个O(nlogk)的算法，特别适合处理海量数据。先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个数字中读入一个数，如果已有的容器中少于k个，就直接把这个放入数
 * 放入容器中，如果容器已有k个数，也就是容器满了，只能替换了，在k个数中找最大数，有可能要删除这个最大数，有可能要插入一个新的数字，这些操作在logk中最掉，总的就是nlogk。
 * 这个容器是什么呢，就是二叉树，每次都要找到k个整数的最大数字，很容易想到最大堆，在最大堆中，根结点的值总是大于它的子树中的任意结点的值。于是我们每次可以在O(1)得到已有的k个数字中的
 * 最大值，但需要O(logk)时间完成插入和删除，自己从头开始写一个最大堆需要一定的代码，这在面试短短的几十分钟内很难完成，我们可以采用红黑树来实现我们的容器。。。
 *
 */
public class LeastSmallOfK {

  public int[] getLeastNumbers(int[] arr, int k) {

    if (k == 0) {
      return new int[0];
    }

    int result[] = new int[k];
    int start = 0;
    int end = arr.length - 1;
    int index = partition(arr, start, end);
    while (index != k-1) {
      if (index > k - 1) {
        end = index - 1;
        index = partition(arr, start, end);
      } else {
        start = index + 1;
        index = partition(arr, start, end);
      }
    }

    for (int i = 0; i < result.length; i++) {
      result[i] = arr[i];
    }
    return result;

  }

  private int partition(int a[], int low, int high) {

    int pivot = a[low];
    while (low < high) {
      while (low < high && a[high] >= pivot) {
        high--;
      }
      a[low] = a[high];
      while (low < high && a[low] <= pivot) {
        low++;
      }
      a[high] = a[low];
    }
    a[low] = pivot;
    return low;
  }

}
