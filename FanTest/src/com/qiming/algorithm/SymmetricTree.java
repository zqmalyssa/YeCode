package com.qiming.algorithm;

/**
 * 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 思路：递归解决，还有个是输出一棵树的镜像，两者的递归套路是不一样的哦
 *
 */
public class SymmetricTree {

  public boolean isSymmetric(TreeNodeSymmetricTree root) {

    return isMirror(root, root);

  }

  private boolean isMirror(TreeNodeSymmetricTree t1, TreeNodeSymmetricTree t2) {

    if (t1 == null && t2 == null) {
      return true;
    }
    if (t1 == null || t2 == null) {
      return false;
    }
    return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);

  }



}

class TreeNodeSymmetricTree {

  int val;
  TreeNodeSymmetricTree left;
  TreeNodeSymmetricTree right;
  TreeNodeSymmetricTree(int x) { val = x; }

}
