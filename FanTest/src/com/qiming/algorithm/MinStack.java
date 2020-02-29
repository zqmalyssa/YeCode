package com.qiming.algorithm;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 实现一个能够得到栈的最小元素的min函数，在该栈中，调用min、push和pop的时间复杂度都是O(1)
 * 思路是用一个辅助栈。每次压数据的时候也在辅助栈中压入最小值。弹出的时候如果是最小值，也在辅助栈中弹出。画画图，注意提交的时候不要用静态变量
 */

public class MinStack {

  private static Stack stack_data = new Stack();
  private static Stack stack_min = new Stack();

  public static void main(String[] args) {
    MinStack test = new MinStack();

    test.push(3);
    System.out.println(test.min());
    test.push(4);
    System.out.println(test.min());
    test.push(2);
    System.out.println(test.min());
    test.push(1);
    System.out.println(test.min());
    test.pop();
    System.out.println(test.min());
    test.pop();
    System.out.println(test.min());
    test.push(0);
    System.out.println(test.min());

  }

  private static int pop (){
    Integer top = null;
    if (!stack_data.isEmpty() && !stack_min.isEmpty()) {
      top = (Integer)(stack_data.pop());
      stack_min.pop();
    }
    return top;
  }

  private static void push (int val){
    stack_data.push(val);
    if (stack_min.isEmpty() || val < (Integer)(stack_min.peek())) {
      stack_min.push(val);
    } else {
      stack_min.push(stack_min.peek());
    }
  }

  private static int min() {
    Integer min = null;
    if (!stack_data.isEmpty() && !stack_min.isEmpty()) {
      min = (Integer)(stack_min.peek());
    }
    return min;
  }

  private static int top (){
    Integer top = null;
    if (!stack_data.isEmpty() && !stack_min.isEmpty()) {
      top = (Integer)(stack_data.peek());
    }
    return top;
  }

}
