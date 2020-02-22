package com.qiming.algorithm.leetcode;

/**
 * 监控二叉树
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。计算监控树的所有节点所需的最小摄像头数量。
 *
 * 输入：[0,0,null,0,0]  输出：1
 *
 * 提示：给定树的节点数的范围是 [1, 1000]。 每个节点的值都是 0。
 *
 * 思路：1：该节点安装了监视器 2：该节点可观，但没有安装监视器 3：该节点不可观
 *
 */
public class BinaryTreeCameras {

  private int ans = 0;

  public int minCameraCover(TreeNode root) {
    if (root == null) return 0;
    if (dfs(root) == 2) ans++;
    return ans;
  }

  // 1：该节点安装了监视器 2：该节点可观，但没有安装监视器 3：该节点不可观
  private int dfs(TreeNode node) {
    if (node == null)
      return 1;
    int left = dfs(node.left), right = dfs(node.right);
    if (left == 2 || right == 2) {
      ans++;
      return 0;
    } else if (left == 0 || right == 0){
      return 1;
    } else
      return 2;
  }

}
