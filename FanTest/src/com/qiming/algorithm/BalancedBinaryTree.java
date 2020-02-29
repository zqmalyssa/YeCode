package com.qiming.algorithm;

/**
 * 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 思路：遍历所有结点求左右子树的高度差显然是不可取的，但是这里面有重复计算的，每个节点真正只遍历一次。用后续遍历的方法遍历二叉树，在遍历到下一个节点之前
 * 我们已经遍历了它的左右子树，只要在遍历每个节点的时候记录它的深度，我们就可以一边遍历，一边判断这个结点是不是平衡的
 *
 */
public class BalancedBinaryTree {

  public boolean isBalanced(TreeNodeBalancedBinaryTree root) {

    //java中没有int的指针传递，用数组替代
    int depth[] = new int[1];
    depth[0] = 0;
    return isBalanced(root, depth);

  }

  private boolean isBalanced(TreeNodeBalancedBinaryTree root, int[] depth) {

    if (root == null) {
      depth[0] = 0;
      return true;
    }
    int left[] = {0}, right[] = {0};
    if (isBalanced(root.left, left) && isBalanced(root.right, right)) {

      int diff = left[0] - right[0];
      if (diff >= -1 && diff <= 1) {
        depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
        return true;
      }

    }

    return false;
  }

}


class TreeNodeBalancedBinaryTree {

  int val;
  TreeNodeBalancedBinaryTree left;
  TreeNodeBalancedBinaryTree right;
  TreeNodeBalancedBinaryTree(int x) { val = x; }

}