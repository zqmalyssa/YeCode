package com.qiming.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 思路：二叉树的DFS或者BFS，然后再反序列化，这边用先序
 *
 */
public class SerializeAndDeserializeBinaryTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNodeSerializeAndDeserializeBinaryTree root) {
    return rserialize(root, "");
  }

  public String rserialize(TreeNodeSerializeAndDeserializeBinaryTree root, String str) {

    if (root == null) {
      str += "null,";
    } else {
      str += String.valueOf(root.val) + ",";
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }

    return str;
  }

  // Decodes your encoded data to tree.
  public TreeNodeSerializeAndDeserializeBinaryTree deserialize(String data) {

    String dataArray[] = data.split(",");
    List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
    return rdeserialize(dataList);

  }

  public TreeNodeSerializeAndDeserializeBinaryTree rdeserialize(List<String> l) {

    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }
    TreeNodeSerializeAndDeserializeBinaryTree root = new TreeNodeSerializeAndDeserializeBinaryTree(Integer.valueOf(l.get(0)));
    l.remove(0);
    //再先序遍历回去
    root.left = rdeserialize(l);
    root.right = rdeserialize(l);

    return root;

  }

}

class TreeNodeSerializeAndDeserializeBinaryTree {

  int val;
  TreeNodeSerializeAndDeserializeBinaryTree left;
  TreeNodeSerializeAndDeserializeBinaryTree right;
  TreeNodeSerializeAndDeserializeBinaryTree(int x) { val = x; }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));