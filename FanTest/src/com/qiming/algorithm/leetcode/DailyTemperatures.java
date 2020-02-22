package com.qiming.algorithm.leetcode;

import java.util.Stack;

/**
 * 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 思路，用单调栈方式解决，但这边不一样的是入栈的是数组的索引，不是值，方便计算过了多少天，这是关键
 *
 */
public class DailyTemperatures {

  public static void main(String[] args) {
    int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};
    temperatures = new DailyTemperatures().dailyTemperatures(temperatures);
    for (int i = 0; i < temperatures.length; i++) {
      System.out.print(temperatures[i] + " ");
    }
  }

  public int[] dailyTemperatures(int[] T) {
    if (T.length == 1) {
      T[0] = 0;
      return T;
    }

    Stack<Integer> stack = new Stack();
    //这边不一样的地方是把索引push到栈中，而不是值，这样方便计算过后多少天
    stack.push(0);
    for (int i = 1; i < T.length; i++) {
      if (!stack.isEmpty() && T[i] <= T[stack.peek()]) {
        stack.push(i);
      } else {
        //peek在栈空的时候会报错的，pop也是
        while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
          //pop的时候就是遇到了更大值
          int index = stack.pop();
          //pop的点就可以计算过了多少天，是i-pop出来的索引
          T[index] = i - index;
        }
        //压入新值
        stack.push(i);
      }
    }
    //最后栈中所有的索引出来的都是没有更高温度的
    while (!stack.isEmpty()) {
      int index = stack.pop();
      T[index] = 0;
    }

    return T;
  }

}
