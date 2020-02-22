package com.qiming.algorithm.nowcoder;

import java.util.Stack;

/**
 *  计算逆波兰式，运算符仅包含"+"，"-"，"*"，"/"，被操作数可能是整数或其他表达式
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *  思路，用栈，如果遇到数字就入栈，遇到符号就计算，结果再入栈
 */
public class EvaluateReversePolish {

  public static void main(String[] args) {
    String[] s = {"2","1","+","3","*"};
    System.out.println(new EvaluateReversePolish().evalRPN(s));
  }

  public int evalRPN(String[] tokens) {

    if (tokens == null || tokens.length == 0) {
      return -1;
    }
    if (tokens.length == 1) {
      return Integer.parseInt(tokens[0]);
    }
    Stack stack = new Stack();
    int result = 0;
    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/") {
        stack.push(Integer.parseInt(tokens[i]));
      } else {
        int operand2 = (Integer)stack.pop();
        int operand1 = (Integer)stack.pop();
        char c = tokens[i].charAt(0);
        result = compute(operand1, operand2, c);
        stack.push(result);
      }
    }
    return result;
  }

  private static int compute(int num1, int num2, char c) {
    switch (c) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        return num1 / num2;
      default:
        return 0;
    }
  }
}
