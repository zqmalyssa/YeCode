package com.qiming.algorithm;

/**
 * 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 思路：相似的还有非二叉搜索树的，要充分利用二叉搜索树的性质。从根节点开始遍历树，如果根结点的值比p，q的值都大，那就去左子树中找，反之亦然，第一个介于p，q的值的结点就是求的结点
 *
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {

  public TreeNodeLowestCommonAncestorOfABinarySearchTree lowestCommonAncestor(TreeNodeLowestCommonAncestorOfABinarySearchTree root, TreeNodeLowestCommonAncestorOfABinarySearchTree p, TreeNodeLowestCommonAncestorOfABinarySearchTree q) {

    /**
     * 以下是递归的写法
     */
//    int parentVal = root.val;
//
//    // Value of p
//    int pVal = p.val;
//
//    // Value of q;
//    int qVal = q.val;
//
//    if (pVal > parentVal && qVal > parentVal) {
//      // If both p and q are greater than parent
//      return lowestCommonAncestor(root.right, p, q);
//    } else if (pVal < parentVal && qVal < parentVal) {
//      // If both p and q are lesser than parent
//      return lowestCommonAncestor(root.left, p, q);
//    } else {
//      // We have found the split point, i.e. the LCA node.
//      return root;
//    }

    /**
     * 以下是非递归的写法
     */
    // Value of p
    int pVal = p.val;

    // Value of q;
    int qVal = q.val;

    // Start from the root node of the tree
    TreeNodeLowestCommonAncestorOfABinarySearchTree node = root;

    // Traverse the tree
    while (node != null) {

      // Value of ancestor/parent node.
      int parentVal = node.val;

      if (pVal > parentVal && qVal > parentVal) {
        // If both p and q are greater than parent
        node = node.right;
      } else if (pVal < parentVal && qVal < parentVal) {
        // If both p and q are lesser than parent
        node = node.left;
      } else {
        // We have found the split point, i.e. the LCA node.
        return node;
      }
    }
    return null;


  }

}

class TreeNodeLowestCommonAncestorOfABinarySearchTree {

  int val;
  TreeNodeLowestCommonAncestorOfABinarySearchTree left;
  TreeNodeLowestCommonAncestorOfABinarySearchTree right;
  TreeNodeLowestCommonAncestorOfABinarySearchTree(int x) { val = x; }

}
