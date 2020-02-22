package com.qiming.algorithm.nowcoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *  万万没想到之抓捕孔连顺
 *  第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 *  第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
 *  输出一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
 */
public class FindScheme {

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//
//    String str1 = scanner.nextLine();
//    String[] array1 = str1.split(" ");
//    int N = Integer.parseInt(array1[0]);
//    int D = Integer.parseInt(array1[1]);
//
//    String str = scanner.nextLine();
//    String[] array = str.split(" ");
//
//    List list = new LinkedList();
//
//    for (int i = 0; i < array.length; i++) {
//      list.add(Integer.parseInt(array[i]));
//    }
//
//    System.out.println(countScheme(list, D));

    /**
     * 可以这样拿int
      */
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int D = sc.nextInt();
    int[] dist = new int[N];
    for (int i = 0; i < N; i++) {
      dist[i] = sc.nextInt();
    }
    long i = totalProgram(dist, D);
    System.out.println(i);

  }


  /**
   * 此方法通过，computeCn一定要用long的参数和输出都要用long
   * int的区间[2147483647 -2147483648]，随便输个998899，那么computeCn的值是498,899,106,651‬
   * 最左边的值固定，再从剩下的元素中Cn2
   * @param dist
   * @param D
   * @return
   */
  public static long totalProgram(int[] dist, int D) {
    long ans = 0;
    for (int i = 0,j = 0;i < dist.length;i++){
      while (i >= 2 && (dist[i] - dist[j]) > D)
        j++;
      ans += computeCn(i - j);
    }
    return ans % 99997867;
  }
  private static long computeCn(long n) {
    return n * (n - 1) / 2;
  }


  /**
   * 测试不通过，使用滑动窗口的
   * @param array
   * @param val
   * @return
   */
  public static int countSchemeWindow(int[] array, int val) {
    int count = 0;
    int left = 0;
    int right = 2;
    while (left < array.length - 2) {
      while (right < array.length && array[right] - array[left] <= val) {
        right += 1;
      }
      if (right - 1 - left >= 2) {
        int num = right - left - 1;
        count = count + num * (num - 1);
      }
      left += 1;
    }
    return count % 99997867;
  }

  /**
   * 测试超时，不管是list还是数组存储的
   * 主要原因是要看清题，是从小到大排列的
   * @param list
   * @param val
   * @return
   */
  public static int countScheme(List list, int val) {
    System.out.println(System.currentTimeMillis());
    int count = 0;
    int[] s = new int[3];
    for (int i = 0; i < list.size(); i++) {
      s[0] = (Integer)list.get(i);
      for (int j = i + 1; j < list.size(); j++) {
        s[1] = (Integer)list.get(j);
        if (Math.abs(s[0] - s[1]) > val) {
          continue;
        }
        for (int k = j + 1; k < list.size(); k++) {
          s[2] = (Integer)list.get(k);
          if (Math.abs(s[0] - s[2]) > val || Math.abs(s[1] - s[2]) > val) {
            continue;
          } else {
            count++;
          }
        }
      }
    }
    System.out.println(System.currentTimeMillis());
    return Math.floorMod(count, 99997867);
  }

}
