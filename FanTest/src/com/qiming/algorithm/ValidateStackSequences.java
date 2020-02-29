package com.qiming.algorithm;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 思路：如果下一个弹出的数字刚好是栈顶的数字，那么就直接弹出，如果下一个弹出的数字不在栈顶，我们就把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字
 * 压入栈顶为止，如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列
 *
 *
 */
public class ValidateStackSequences {

  public boolean validateStackSequences(int[] pushed, int[] popped) {

    if (pushed.length == 0 && popped.length == 0) {
      return true;
    }

    Stack<Integer> stack = new Stack();
    int pushIndex = 0;

    for (int poppedIndex = 0; poppedIndex < popped.length; poppedIndex++) {
      //当还有数可以入栈并且 栈顶元素和要弹出的数不一样，那么继续入栈
      while (pushIndex < pushed.length && (stack.empty() || stack.peek() != popped[poppedIndex])) {
        stack.push(pushed[pushIndex++]);
      }
      if (stack.peek() != popped[poppedIndex]) {
        return false;
      } else {
        stack.pop();
      }

    }

    return true;
  }

}
