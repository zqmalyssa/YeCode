package com.qiming.algorithm.leetcode;

import java.util.Stack;

/**
 * 括号的分数
 *
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：1、() 得 1 分。2、AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。3、(A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * 输入： "()" 输出： 1  输入： "(())" 输出： 2  输入： "()()"  输出： 2  输入： "(()(()))"  输出： 6
 *
 * 提示：1、S 是平衡括号字符串，且只含有 ( 和 ) 。2、2 <= S.length <= 50
 *
 * 思路 立马想到的是用栈。但是这个题目怎么用
 *
 * 字符串 S 中的每一个位置都有一个“深度”，即该位置外侧嵌套的括号数目。例如，字符串 (()(.())) 中的 . 的深度为 2，因为它外侧嵌套了 2 层括号：(__(.__))。
 * 我们用一个栈来维护当前所在的深度，以及每一层深度的得分。当我们遇到一个左括号 ( 时，我们将深度加一并且新的深度的得分置为 0。
 * 当我们遇到一个右括号 ) 时，我们将当前深度的得分乘二并加到上一层的深度得分。这里有一种例外情况，如果遇到的是 ()，那么只将得分加一
 *
 * "(()(()))"来做一个示例
 *
 * [0, 0] (
 * [0, 0, 0] ((
 * [0, 1] (()
 * [0, 1, 0] (()(
 * [0, 1, 0, 0] (()((
 * [0, 1, 1] (()(()
 * [0, 3] (()(())
 * [6] (()(()))
 *
 */
public class ScoreOfParentheses {

  public int scoreOfParentheses(String S) {

    Stack<Integer> stack = new Stack();
    stack.push(0); // The score of the current frame

    for (char c: S.toCharArray()) {
      if (c == '(')
        stack.push(0);
      else {
        //当前深度的得分
        int v = stack.pop();
        //上一层的深度得分
        int w = stack.pop();
        stack.push(w + Math.max(2 * v, 1));
      }
    }

    return stack.pop();

  }

}
