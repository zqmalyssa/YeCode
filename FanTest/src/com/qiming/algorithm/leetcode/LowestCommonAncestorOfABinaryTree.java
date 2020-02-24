package com.qiming.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 输出: 5
 *
 * 思路：用结点与父结点的关系用hashmap保存，这样，可以知道p的所有祖先set集合，再看q的祖先，第一个在set中出现的就是了
 *
 */
public class LowestCommonAncestorOfABinaryTree {

  public TreeNodeLowestCommonAncestorOfABinaryTree lowestCommonAncestor(TreeNodeLowestCommonAncestorOfABinaryTree root, TreeNodeLowestCommonAncestorOfABinaryTree p, TreeNodeLowestCommonAncestorOfABinaryTree q) {

    Stack<TreeNodeLowestCommonAncestorOfABinaryTree> stack = new Stack();
    //父亲字典
    Map<TreeNodeLowestCommonAncestorOfABinaryTree,TreeNodeLowestCommonAncestorOfABinaryTree> parent = new HashMap();

    parent.put(root, null);
    stack.push(root);

    //迭代直到即发现P，又发现Q
    while (!parent.containsKey(p) || !parent.containsKey(q)) {

      TreeNodeLowestCommonAncestorOfABinaryTree node = stack.pop();

      //保持记录父结点
      if (node.left != null) {
        parent.put(node.left, node);
        stack.push(node.left);
      }

      if (node.right != null) {
        parent.put(node.right, node);
        stack.push(node.right);
      }

    }

    //p结点的祖先集合
    Set<TreeNodeLowestCommonAncestorOfABinaryTree> ancestors = new HashSet<>();

    while (p != null) {
      ancestors.add(p);
      p = parent.get(p);
    }
    //遍历q的祖先，如果第一个在集合中出现，就是了
    while (!ancestors.contains(q)) {
      q = parent.get(q);
    }

    return q;

  }

}


class TreeNodeLowestCommonAncestorOfABinaryTree {

  int val;
  TreeNodeLowestCommonAncestorOfABinaryTree left;
  TreeNodeLowestCommonAncestorOfABinaryTree right;
  TreeNodeLowestCommonAncestorOfABinaryTree(int x) { val = x; }

}