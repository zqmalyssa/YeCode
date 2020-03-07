package com.qiming.algorithm;

/**
 * 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法。
 *
 * 输入: 12258 输出: 5 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 思路：首先，绝大部分树形问题都可以用回溯来解决，这道抽象成树模型后就是求一颗二叉树从根结点到达叶子结点的路径总数。因为每次选择都只有两个，犹如二叉树的分支
 * 对于13，你第一次可以选择一位，就是1，你也可以选择13，所以最多就是两个选择，去走左子树还是右子树，走到叶子结点就返回1，代表这条路径可以到达终点
 *
 *
 *
 */
public class IntegerToString {

  public static void main(String[] args) {

    int num = 542;

//    int result = new IntegerToString().translateNum(num);
//    System.out.println(result);

  }

  public int translateNum(int num) {

    String s = String.valueOf(num);
    return backtrace(s, 0);

  }

  private int backtrace(String s, int index) {
    int n = s.length();

    if (index == n) {
      return 1;
    }
    //特殊情况，看最后怎么判断双位数的不能
    if (index == n -1 || s.charAt(index) == '0' || Integer.valueOf(s.substring(index, index + 2)) > 25) {
      return backtrace(s, index+1);
    }

    return backtrace(s, index + 1) + backtrace(s, index + 2);

  }

}
