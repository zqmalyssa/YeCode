package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 思路：递归的前序遍历，记得返回上一个节点的时候removeLast，记得拷贝结果
 *
 */
public class PathSumII {

  List<List<Integer>> list = new LinkedList<>();
  LinkedList<Integer> inner = new LinkedList<>();

  public List<List<Integer>> pathSum(TreeNodePathSumII root, int sum) {

    if (root == null) {
      return list;
    }
    sum -= root.val;
    inner.add(root.val);
    if (root.left == null && root.right == null) {
      if (sum == 0) {
        list.add(new LinkedList<>(inner));  //要拷贝的，跟回溯时一样
      }
    }
    if (root.left != null) {
      pathSum(root.left, sum);
    }
    if (root.right != null) {
      pathSum(root.right, sum);
    }
    inner.removeLast();

    return list;
  }

}

class TreeNodePathSumII {
  int val;
  TreeNodePathSumII left;
  TreeNodePathSumII right;
  TreeNodePathSumII(int x) { val = x; }
}