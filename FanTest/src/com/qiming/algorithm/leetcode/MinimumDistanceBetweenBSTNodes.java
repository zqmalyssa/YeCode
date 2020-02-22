package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树结点最小距离
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 输入: root = [4,2,6,1,3,null,null] 输出: 1  解释: 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 二叉树的大小范围在 2 到 100。 二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 *
 * 思路：首先看清是二叉搜索树，然后就是中序遍历从小到大，最小就是相邻两个差值的最小
 *
 */
public class MinimumDistanceBetweenBSTNodes {

  public static void main(String[] args) {
    TreeNodeMinimumDistanceBetweenBSTNodes t1 = new TreeNodeMinimumDistanceBetweenBSTNodes(90);
    TreeNodeMinimumDistanceBetweenBSTNodes t2 = new TreeNodeMinimumDistanceBetweenBSTNodes(69);
    TreeNodeMinimumDistanceBetweenBSTNodes t3 = new TreeNodeMinimumDistanceBetweenBSTNodes(49);
    TreeNodeMinimumDistanceBetweenBSTNodes t4 = new TreeNodeMinimumDistanceBetweenBSTNodes(89);
    TreeNodeMinimumDistanceBetweenBSTNodes t5 = new TreeNodeMinimumDistanceBetweenBSTNodes(52);

    t1.left = t2;
    t2.left = t3;
    t2.right = t4;
    t3.right = t5;

    new MinimumDistanceBetweenBSTNodes().minDiffInBST(t1);

  }


  public int minDiffInBST(TreeNodeMinimumDistanceBetweenBSTNodes root) {

    //二叉树的中序遍历
    Stack<TreeNodeMinimumDistanceBetweenBSTNodes> stack = new Stack();
    TreeNodeMinimumDistanceBetweenBSTNodes p = root;
    Integer minMax = Integer.MAX_VALUE;
    Integer pre = null;
    while (p != null || !stack.isEmpty()) {
      //左结点全部入栈
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        //这边也要是p哈
        p = stack.pop();
        //增加，在这边有个小技巧，就是我不想第一个值减初始的pre，而是在上面把pre置null，然后判断一下
        if (pre != null) {
          minMax = Math.min(p.val - pre, minMax);
        }
        pre = p.val;

        p = p.right;
      }
    }
    return minMax;
  }

}

class TreeNodeMinimumDistanceBetweenBSTNodes {

  int val;
  TreeNodeMinimumDistanceBetweenBSTNodes left;
  TreeNodeMinimumDistanceBetweenBSTNodes right;
  TreeNodeMinimumDistanceBetweenBSTNodes(int x) { val = x; }

}
