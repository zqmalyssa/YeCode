package com.qiming.algorithm.nowcoder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 特征提取
 * 第一行包含一个正整数N，代表测试用例的个数。
 * 每个测试用例的第一行包含一个正整数M，代表视频的帧数。
 * 接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
 * 所有用例的输入特征总数和<100000
 * N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
 * 特征取值均为非负整数。
 * 思路是用linkedHashMap和暴力破解
 */
public class FeatureExtract {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int result = 0;
    int sampleCount = scanner.nextInt();
    for (int i = 0; i < sampleCount; i++) {
      int frameCount = scanner.nextInt();
      LinkedHashMap lhm = new LinkedHashMap(frameCount);
      for (int j = 0; j < frameCount; j++) {
        int vectorCount = scanner.nextInt();
        Vector[] vector = new Vector[vectorCount];
        for (int k = 0; k < vectorCount; k++) {
          int x = scanner.nextInt();
          int y = scanner.nextInt();
          Vector v = new Vector(x, y);
          vector[k] = v;
        }
        lhm.put(j, vector);
      }
      int thisSampleCount = frameList(lhm);
      result = Math.max(result, thisSampleCount);
    }
    System.out.println(result);
  }

  public static int frameList(Map map) {
    int result = 0;
    for (int i = 0; i < map.size(); i++) {
      Vector[] vector = (Vector[])map.get(i);
      for (int j = 0; j < vector.length; j++) {
        Vector toCompare = vector[j];
        int tmpResult = 1;
        int k = i + 1;
        while(k < map.size()) {
          Vector[] nextVector = (Vector[])map.get(k);
          boolean hasNext = false;
          for (int m = 0; m < nextVector.length; m++) {
            if (nextVector[m].x == toCompare.x && nextVector[m].y == toCompare.y) {
              tmpResult = tmpResult + 1;
              k++;
              hasNext = true;
            }
          }
          if (!hasNext) {
            break;
          }
        }
        result = Math.max(result, tmpResult);
      }
    }
    return result;
  }


}

class Vector{
  int x;
  int y;

  public Vector(int x, int y) {
    this.x = x;
    this.y = y;
  }
}