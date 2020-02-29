package com.qiming.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的高度
 */
public class DepthOfTree {

  public static void main(String[] args) {
    TreeNodeDepthOfTree t1 = new TreeNodeDepthOfTree(1);
    TreeNodeDepthOfTree t2 = new TreeNodeDepthOfTree(1);
    TreeNodeDepthOfTree t3 = new TreeNodeDepthOfTree(1);
    TreeNodeDepthOfTree t4 = new TreeNodeDepthOfTree(1);
    TreeNodeDepthOfTree t5 = new TreeNodeDepthOfTree(1);
    TreeNodeDepthOfTree t6 = new TreeNodeDepthOfTree(1);
    //有陷阱
    TreeNodeDepthOfTree t7 = new TreeNodeDepthOfTree(1);
    t1.left = t2;
    t1.right = t3;
    t2.left = t4;
    t4.right = t5;
    t5.left = t6;
    //陷阱
    t2.right = t7;
    System.out.println(new DepthOfTree().depthByIteration(t1));
    System.out.println(new DepthOfTree().depthByRecursion(t1));
  }

  /**
   * 递归求高度
   * @param root
   * @return
   */
  public int depthByRecursion(TreeNodeDepthOfTree root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = depthByRecursion(root.left) + 1;
    int rightDepth = depthByRecursion(root.right) + 1;

    return leftDepth > rightDepth ? leftDepth : rightDepth;

  }

  /**
   * 非递归求高度，层次遍历
   * @param root
   * @return
   */
  public int depthByIteration(TreeNodeDepthOfTree root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNodeDepthOfTree> queue = new LinkedList();
    queue.offer(root);
    int height = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNodeDepthOfTree p = queue.poll();
        if (p.left != null) {
          queue.offer(p.left);
        }
        if (p.right != null) {
          queue.offer(p.right);
        }
      }
      height++;
    }
    return height;
  }

}

class TreeNodeDepthOfTree {

  int val;
  TreeNodeDepthOfTree left;
  TreeNodeDepthOfTree right;
  public TreeNodeDepthOfTree(int val) {
    this.val = val;
  }
}