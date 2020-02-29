package com.qiming.algorithm.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Inputs:
 *
 * {"geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer", "science", "zoom", "yup", "fire", "in", "be", "data", "geeks"}
 *
 * and the first 2 words with the highest frequency.
 *
 * Outputs: {'geeks", "be"}
 *
 * where "geek" has a frequency of 3 and "be" has a frequency of 2.
 *
 */
public class TestMain2 {

  public static void main(String[] args) {

    String[] test1 = {"geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer", "science", "zoom", "yup", "fire", "in", "be", "data", "geeks"};
    String[] test2 = {"learn", "can", "be", "computer", "science", "zoom", "yup", "fire", "in", "be", "data", "geeks"};
    String[] test3 = {"learn", "learn", "learn", "learn", "learn", "learn", "learn", "learn", "learn", "learn", "learn", "learn"};

    List<String> result1 = new TestMain2().getFrequencyWords(test1, 2);
    List<String> result2 = new TestMain2().getFrequencyWords(test2, 3);
    List<String> result3 = new TestMain2().getFrequencyWords(test3, 4);

    for (String s : result1) {
      System.out.print(s + " ");
    }

    System.out.println();

    for (String s : result2) {
      System.out.print(s + " ");
    }

    System.out.println();

    for (String s : result3) {
      System.out.print(s + " ");
    }

  }


  public List<String> getFrequencyWords(String[] word, int k) {

    Map<String, Integer> map = new HashMap<>();

    for (String s : word) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    List<String> result = new ArrayList<>(map.keySet());

    Collections.sort(result, (u1, u2) -> map.get(u1).equals(map.get(u2)) ? u1.compareTo(u2) : map.get(u2) - map.get(u1));

    if (result.size() < k) {
      return new ArrayList<String>();
    }

    return result.subList(0, k);

  }

}
