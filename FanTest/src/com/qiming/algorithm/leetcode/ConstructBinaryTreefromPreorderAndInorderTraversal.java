package com.qiming.algorithm.leetcode;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。你可以假设树中没有重复的元素。
 * 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 思路：首先，preorder 中的第一个元素一定是树的根，这个根又将 inorder 序列分成了左右两棵子树。现在我们只需要将先序遍历的数组中删除根元素，然后重复上面的过程处理左右两棵子树。
 * 还有前序遍历中 左子树序列的值 都在 右子树序列的值前面，所以递归中处理左子树先，数组++完了，在处理右子树的时候，数组pre_inx也到了右子树了
 *
 *
 */
public class ConstructBinaryTreefromPreorderAndInorderTraversal {

  int pre_idx = 0;
  int[] preorder;
  int[] inorder;
  HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

  public TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal buildTree(int[] preorder, int[] inorder) {

    this.preorder = preorder;
    this.inorder = inorder;

    //构建hashmap，中序中各个数的位置
    int idx = 0;
    for (int i : inorder) {
      idx_map.put(i, idx++);
    }
    return helper(0, inorder.length);

  }

  public TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal helper(int in_left, int in_right) {
    if (in_left == in_right) {
      return null;
    }

    int root_val = preorder[pre_idx];
    TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal root = new TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal(root_val);

    int index = idx_map.get(root_val);
    pre_idx++;
    root.left = helper(in_left, index);
    root.right = helper(index + 1, in_right);
    return root;

  }

}


class TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal {

  int val;
  TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal left;
  TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal right;
  TreeNodeConstructBinaryTreefromPreorderAndInorderTraversal(int x) { val = x; }

}