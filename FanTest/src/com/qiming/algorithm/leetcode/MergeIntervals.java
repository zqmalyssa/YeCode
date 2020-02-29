package com.qiming.algorithm.leetcode;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1: 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 思路：如果我们按照区间的 start 大小排序，那么在这个排序的列表中可以合并的区间一定是连续的。首先，我们将列表按上述方式排序。然后，我们将第一个区间插入 merged 数组中，
 * 然后按顺序考虑之后的每个区间：如果当前区间的左端点在前一个区间的右端点之后，那么他们不会重合，我们可以直接将这个区间插入 merged 中；否则，他们重合，
 * 我们用当前区间的右端点更新前一个区间的右端点 end 如果前者数值比后者大的话。
 *
 *
 */
public class MergeIntervals {
  private static class Interval {
    int start;
    int end;
    Interval(int[] interval) {
      this.start = interval[0];
      this.end = interval[1];
    }

    int[] toArray() {
      return new int[]{this.start, this.end};
    }
  }

  public int[][] merge(int[][] intervals) {

    LinkedList<Interval> intervalsList = new LinkedList<Interval>();
    for (int[] interval : intervals) {
      intervalsList.add(new Interval(interval));
    }

    intervalsList.sort(new IntervalComparator());

    LinkedList<Interval> merged = new LinkedList<Interval>();
    for (Interval interval : intervalsList) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast().end < interval.start) {
        merged.add(interval);
      }
      // otherwise, there is overlap, so we merge the current and previous
      // intervals.
      else {
        merged.getLast().end = Math.max(merged.getLast().end, interval.end);
      }
    }

    int i = 0;
    int [][]result = new int[merged.size()][2];
    for (Interval interval : merged) {
      result[i] = interval.toArray();
      i++;
    }

    return result;

  }

  private static class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
      return Integer.compare(a.start, b.start);
    }
  }


}
