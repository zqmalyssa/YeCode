package com.qiming.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 匹配子序列的单词数
 *
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。输入: S = "abcde" words = ["a", "bb", "acd", "ace"] 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 *
 * 注意: 所有在words和 S 里的单词都只由小写字母组成。S 的长度在 [1, 50000]。words 的长度在 [1, 5000]。words[i]的长度在[1, 50]。
 *
 * 思路，构建一种桶的结构，把桶装在26个字母中，桶的构造是根据words中词的单词的首字母构造再不停变换
 *
 */
public class NumberOfMatchingSubsequences {

  public int numMatchingSubseq(String S, String[] words) {

    int ans = 0;
    ArrayList<Node>[] heads = new ArrayList[26];
    for (int i = 0; i < 26; ++i)
      heads[i] = new ArrayList<Node>();

    for (String word: words)
      heads[word.charAt(0) - 'a'].add(new Node(word, 0));

    for (char c: S.toCharArray()) {
      ArrayList<Node> old_bucket = heads[c - 'a'];
      //重置一个list的node
      heads[c - 'a'] = new ArrayList<Node>();

      for (Node node: old_bucket) {
        node.index++;
        if (node.index == node.word.length()) {
          ans++;
        } else {
          heads[node.word.charAt(node.index) - 'a'].add(node);
        }
      }
      old_bucket.clear();
    }
    return ans;

  }

}
class Node {
  String word;
  //用于判断最后的机构
  int index;
  public Node(String w, int i) {
    word = w;
    index = i;
  }
}