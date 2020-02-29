package com.qiming.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前K个高频单词
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 思路：hashmap存储单词的次数，然后排序
 *
 *
 */
public class TopKFrequentWords {

  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> count = new HashMap();
    for (String word: words) {
      count.put(word, count.getOrDefault(word, 0) + 1);
    }
    List<String> candidates = new ArrayList(count.keySet());
    Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
        w1.compareTo(w2) : count.get(w2) - count.get(w1));

    return candidates.subList(0, k);


  }

}
