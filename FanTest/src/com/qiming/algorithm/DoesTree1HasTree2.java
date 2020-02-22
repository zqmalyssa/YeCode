package com.qiming.algorithm;

/**
 * 输入A，B两个二叉树，判断B是不是A的子结构
 * 分成两步走，第一步找到树A中与B的根结点的值一样的结点R，第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构
 * 遍历可以用递归的方式去遍历，也可以用循环的方式去遍历，面试可以通常用递归的方式进行
 */
public class DoesTree1HasTree2 {

  public static void main(String args[]) {
    BinTreeNode b1 = new BinTreeNode(4, null, null);
    BinTreeNode b2 = new BinTreeNode(7, null, null);

    BinTreeNode b3 = new BinTreeNode(2, b1, b2);
    BinTreeNode b4 = new BinTreeNode(9, null, null);

    BinTreeNode b5 = new BinTreeNode(8, b4, b3);
    BinTreeNode b6 = new BinTreeNode(7, null, null);

    BinTreeNode b7 = new BinTreeNode(8, b5, b6);

    BinTreeNode b8 = new BinTreeNode(9, null, null);
//    BinTreeNode b9 = new BinTreeNode(2, null, null);
    BinTreeNode b9 = new BinTreeNode(3, null, null);
    BinTreeNode b10 = new BinTreeNode(8, b8, b9);

    boolean result = hasSubtree(b7, b10);

    System.out.println(result);

  }

  private static boolean hasSubtree(BinTreeNode root1, BinTreeNode root2) {
    boolean result = false;
    if (root1 != null && root2 != null) {
      if (root1.getVal() == root2.getVal()) {
        result = doesTree1HasTree2(root1, root2);
      }
      //去左子树找找
      if (!result) {
        result = hasSubtree(root1.getLeft(), root2);
      }
      //去右子树找找
      if (!result) {
        result = hasSubtree(root1.getRight(), root2);
      }
    }
    return result;
  }

  private static boolean doesTree1HasTree2(BinTreeNode tree1, BinTreeNode tree2) {

    if (tree2 == null) {
      return true;
    }

    if (tree1 == null) {
      return false;
    }

    if (tree1.getVal() != tree2.getVal()) {
      return false;
    }

    return doesTree1HasTree2(tree1.getLeft(), tree2.getLeft()) && doesTree1HasTree2(tree1.getRight(), tree2.getRight());
  }

}
