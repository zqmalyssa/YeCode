package com.qiming.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 思路是将层次遍历的队列换成栈，然后需要交叉访问左右子树的顺序
 */
public class BinaryTreeZigzag {

  public static void main(String[] args) {
    TreeNodeBinaryTreeZigzag root = new TreeNodeBinaryTreeZigzag(1);
    TreeNodeBinaryTreeZigzag left1 = new TreeNodeBinaryTreeZigzag(2);
    TreeNodeBinaryTreeZigzag right1 = new TreeNodeBinaryTreeZigzag(3);
    TreeNodeBinaryTreeZigzag left2 = new TreeNodeBinaryTreeZigzag(4);
    TreeNodeBinaryTreeZigzag right2 = new TreeNodeBinaryTreeZigzag(5);
    root.left = left1;
    root.right = right1;
    left1.left = left2;
    left1.right = right2;

    new BinaryTreeZigzag().zigzagLevelOrder(root);
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNodeBinaryTreeZigzag root) {
    if (root == null) {
      return new LinkedList<>();
    }

    List<List<Integer>> result = new LinkedList<>();

    Stack stack = new Stack();
    stack.push(root);
    boolean rightThenLeft = false;
    while (!stack.isEmpty()) {
      //每一层的size
      int size = stack.size();
      //存储结果
      List<Integer> list = new LinkedList<>();
      //存储层的结点
      Queue queue = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNodeBinaryTreeZigzag p = (TreeNodeBinaryTreeZigzag)stack.pop();
        list.add(p.val);
        queue.offer(p);
      }
      //加入集合
      result.add(list);
      //入栈

      while (!queue.isEmpty()) {
        TreeNodeBinaryTreeZigzag q = (TreeNodeBinaryTreeZigzag)queue.poll();
        //入栈之前需要交叉变化
        if (rightThenLeft) {
          if (q.right != null) {
            stack.push(q.right);
          }

          if (q.left != null) {
            stack.push(q.left);
          }

        } else {
          if (q.left != null) {
            stack.push(q.left);
          }

          if (q.right != null) {
            stack.push(q.right);
          }

        }

      }
      //交叉左右顺序
      rightThenLeft = !rightThenLeft;

    }
    return result;
  }

}


class TreeNodeBinaryTreeZigzag {

  int val;
  TreeNodeBinaryTreeZigzag left;
  TreeNodeBinaryTreeZigzag right;
  public TreeNodeBinaryTreeZigzag(int val) {
    this.val = val;
  }

}