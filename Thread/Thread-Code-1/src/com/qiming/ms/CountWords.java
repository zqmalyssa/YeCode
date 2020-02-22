package com.qiming.ms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 本地有很多文件，每个文件里面都有若干单词，用多线程技术去完成各种单词数量的总结
 */

public class CountWords implements Callable{

  private int beginTextNum;
  private int endTextNum;

  public CountWords(int beginTextNum, int endTextNum) {
    this.beginTextNum = beginTextNum;
    this.endTextNum = endTextNum;
  }

  public static void main(String[] args) {

//    try {
//      Thread.sleep(15000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    //构建一个线程池
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10),
    Executors.defaultThreadFactory(), new AbortPolicy());

    Map<String, Integer> result = new TreeMap<String, Integer>();
    //如果采用下面的方式，get的时候就会阻塞，那么就是串行的起线程了，相当于一个一个做完
//    for (int i = 0; i < 6; i++) {
//      Future<Map<String, Integer>> future = executor.submit(new CountWords((i*5) + 1, (i*5) + 5));
//      try {
//        Map<String, Integer> map = future.get();
//        mergeMap(result, map);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      } catch (ExecutionException e) {
//        e.printStackTrace();
//      }
//    }

    //下面这个方式是并行的线程，返回是无序的，说明是多线程在跑
    Future<Map<String, Integer>> future1 = executor.submit(new CountWords(1, 5));
    Future<Map<String, Integer>> future2 = executor.submit(new CountWords(6, 10));
    Future<Map<String, Integer>> future3 = executor.submit(new CountWords(11, 15));
    Future<Map<String, Integer>> future4 = executor.submit(new CountWords(16, 20));
    Future<Map<String, Integer>> future5 = executor.submit(new CountWords(21, 25));
    Future<Map<String, Integer>> future6 = executor.submit(new CountWords(26, 30));
    try {
      Map<String, Integer> map1 = future1.get();
      Map<String, Integer> map2 = future2.get();
      Map<String, Integer> map3 = future3.get();
      Map<String, Integer> map4 = future4.get();
      Map<String, Integer> map5 = future5.get();
      Map<String, Integer> map6 = future6.get();
      mergeMap(result, map1);
      mergeMap(result, map2);
      mergeMap(result, map3);
      mergeMap(result, map4);
      mergeMap(result, map5);
      mergeMap(result, map6);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    Set<String> keys = result.keySet();
    for (String key : keys) {
      Integer value = result.get(key);
      System.out.println("所有文本中单词 " + key + " 的次数是" + value);
    }

    executor.shutdown();

//    try {
//      Thread.sleep(Integer.MAX_VALUE);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }

  @Override
  public Map<String, Integer> call() throws Exception {

    Pattern pattern = Pattern.compile("[a-zA-Z']+"); //a到z或A到Z
    Map<String, Integer> result = new TreeMap<String, Integer>();
    for (int i = beginTextNum; i <= endTextNum; i++) {
      BufferedReader br = null;
      StringBuilder sb = new StringBuilder();
      String filePath = "E:\\Code\\TestDataSample\\word" + i + ".txt";
      try {
        br = new BufferedReader(new FileReader(filePath));
        String line = null;
        while ((line = br.readLine()) != null) {
          sb = sb.append(line);
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } finally {
        br.close();
      }

      String sbLowCase = sb.toString().toLowerCase();
      Matcher matcher = pattern.matcher(sbLowCase);

      //单词的总数
      int total = 0;
      Map<String, Integer> map = new TreeMap<String, Integer>();
      while (matcher.find()) {
        String word = matcher.group();
        total++;
        //Integer用null
        Integer num = null;
        if (map.containsKey(word)) {
          num = map.get(word);
          num += 1;
        } else {
          num = 1;
        }
        map.put(word, num);
      }

      Set<String> keys = map.keySet();
      for (String key : keys) {
        Integer value = map.get(key);
        System.out.println("第" + i +"个文本中单词 " + key + " 的次数是" + value);
      }
      System.out.println("第" + i + "个文本中单词总数是 " + total);
      System.out.println("第" + i + "个文本中不重复的单词总数是 " + map.size());

      //合并一下
      mergeMap(result, map);
    }
    return result;
  }

  public static void mergeMap(Map<String, Integer> base, Map<String, Integer> map) {
    Set<String> set = map.keySet();
    for (String key : set) {
      Integer value = null;
      if (base.containsKey(key)) {
        Integer newValue = map.get(key);
        Integer oldValue = base.get(key);
        value = newValue + oldValue;
      } else {
        value = map.get(key);
      }
      base.put(key, value);
    }
  }
}
