package com.qiming.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {


  public static void main(String[] args) {

    //正常的过滤
    List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");
    System.out.println("过滤之前:" + list);
    List<String> result = new ArrayList<>();
    for (String str : list) {
      if (!"李四".equals(str)) {
        result.add(str);
      }
    }
    System.out.println("过滤之后:" + result);

    //Stream的过滤，简化写法
    List<String> result2 = list.stream().filter(str -> !"李四".equals(str)).collect(Collectors.toList());
    System.out.println("stream 过滤之后:" + result2);

//    try {
//      Stream<String> stream2 = Stream.of("a", "b", "c");
//      // 转换成 Array
//      String[] strArray1 = stream2.toArray(String[]::new);
//
//      // 转换成 Collection
//      List<String> list1 = stream2.collect(Collectors.toList()); //这行就抛错了，因为已经使用了一次
//      List<String> list2 = stream2.collect(Collectors.toCollection(ArrayList::new));
//      Set set1 = stream2.collect(Collectors.toSet());
//      Stack stack1 = stream2.collect(Collectors.toCollection(Stack::new));
//
//      // 转换成 String
////      String str = stream.collect(Collectors.joining()).toString();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

    String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
    System.out.println("字符串拼接:" + concat);

  }


}
