package com.qiming.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 先构建二叉搜索树，再找匹配的所有路径并打印出来
 */
public class BinTreePathFind {

  //路径计数器
  private static int count = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //获取第一行输入，默认是一个数值
    int N  = Integer.valueOf(sc.nextLine());
    //获取第二行输入，默认是一串逗号间隔的数字字符串
    String line =  sc.nextLine();
    //开始计算
    new BinTreePathFind().compute(N, line);
  }

/**
 * 构建二叉树搜索树及计算路径的入口
 * @param N 期望值
 * @param line 输入的字符串
 */
  public void compute(int N, String line){
    String[] arr = line.split(",");
    int len = arr.length;
    if (len == 0) {
      throw new InvalidNodeException("输入错误，请输入至少一个元素");
    }
    int[] num = new int[len];
    for (int i = 0; i < len; i++) {
      num[i] = Integer.valueOf(arr[i]);
    }

    BinTreeNode root = buildBST(num);
    findPath(root, N);
  }

/**
 * 用整型数组构建二叉搜索树
 * @param num 整型数组
 * @return
 */
  private BinTreeNode buildBST(int[] num) {
    BinTreeNode root = new BinTreeNode(num[0], null, null);
    for (int i = 1; i < num.length; i++) {
      createBST(root, num[i]);
    }
    return root;
  }

/**
 * 递归构建二叉搜索树
 * @param node
 * @param val
 */
  private void createBST(BinTreeNode node, int val) {
    if (val == node.getVal()) {
      //有值相同，报错
      throw new InvalidNodeException("输入错误，不能有值相同的元素");
    } else if (val < node.getVal()) {
      if (null == node.getLeft()) {
        node.setLeft(new BinTreeNode(val, null, null));
      } else {
        createBST(node.getLeft(), val);
      }
    } else {
      if (null == node.getRight()) {
        node.setRight(new BinTreeNode(val, null, null));
      } else {
        createBST(node.getRight(), val);
      }
    }
  }

/**
 * 查找路径入口
 * @param root
 * @param expectedSum
 */
  private void findPath(BinTreeNode root, int expectedSum) {
    if (root == null) {
      return;
    }
    LinkedList<BinTreeNode> stack = new LinkedList<BinTreeNode>();
    findCorePath(root, expectedSum, stack, 0);
    if (count == 0) {
      System.out.print("error");
    }
  }

/**
 * 查找路径核心方法
 * @param root
 * @param expectedSum
 * @param stack
 * @param currentSum
 */
  private void findCorePath(BinTreeNode root, int expectedSum, LinkedList<BinTreeNode> stack, int currentSum) {
    //入栈
    currentSum += root.getVal();
    stack.push(root);
    if (currentSum == expectedSum && root.isLeaf()) {
      Iterator<BinTreeNode> iterator = stack.descendingIterator();
      StringBuilder sb = new StringBuilder();
      while(iterator.hasNext()) {
        sb.append(iterator.next().getVal()).append(",");
      }
      System.out.print(sb.substring(0, sb.length()-1) + "\n");
      count++;
    }
    //否则继续寻找
    if (root.getLeft() != null) {
      findCorePath(root.getLeft(), expectedSum, stack, currentSum);
    }
    if (root.getRight() != null) {
      findCorePath(root.getRight(), expectedSum, stack, currentSum);
    }
    stack.pop();
  }
}

/**
 * 定义二叉搜索树Node
 */
class BinTreeNode {

  private int val;
  private BinTreeNode left;
  private BinTreeNode right;

  public BinTreeNode(int val, BinTreeNode left, BinTreeNode right) {
    this.val = val;
    this.left = left;
    this.right =right;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public BinTreeNode getLeft() {
    return left;
  }

  public void setLeft(BinTreeNode left) {
    this.left = left;
  }

  public BinTreeNode getRight() {
    return right;
  }

  public void setRight(BinTreeNode right) {
    this.right = right;
  }

  public boolean isLeaf() {
    return this.getLeft() == null && this.getRight() == null;
  }

}

/**
 * 定义基本异常
 */
class InvalidNodeException extends RuntimeException {

  public InvalidNodeException(String err) {
    super(err);
  }

}

