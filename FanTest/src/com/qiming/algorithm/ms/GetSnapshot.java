package com.qiming.algorithm.ms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetSnapshot {

  private static final String invalidFormat = "Invalid format";
  private static final String conflictFound = "Conflict found at ";
  private static final String errorData = "error_data";
  private static final String UUID_PATTERN = "[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}";
  private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  private Map<String, Animal> map = new HashMap(1024);

  public GetSnapshot() {
    dataFormat.setLenient(false);
  }

  public static void main(String[] args) {

    try {
      File file = new File("E:\\Code\\TestHistoryData\\testData.txt");
      BufferedReader br = new BufferedReader(new FileReader(file));
      StringBuilder sb = new StringBuilder();
      String temp = null;
      while ((temp = br.readLine()) != null) {
        //拼接换行符
        sb.append(temp + "\n");
      }
      br.close();
//      System.out.println(new GetSnapshot().getSnapShot(sb.toString(), "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155"));
      System.out.println(new GetSnapshot().getSnapShot(sb.toString(), "351055db-33e6-4f9b-bfe1-16f1ac446ac1"));
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  /**
   * 获取某个时间点动物的快照
   * @param historyData
   * @param id
   * @return
   */
  public String getSnapShot(String historyData, String id) {

    if (historyData == null || id == null) {
      return invalidFormat;
    }

    String strs[] = historyData.split("\n");

    /**
     * 先校验 再确认是否有和id的匹配
     */
    for (int i = 0; i < strs.length; i++) {
      //校验ID是否符合UUID
      if (strs[i].matches(UUID_PATTERN)) {
        //校验时间是否符合标准时间
        if (i + 1 < strs.length && strs[i+1] != null) {
          try {
            dataFormat.parse(strs[i+1]);
          } catch (ParseException e) {
            return invalidFormat;
          }
        }
        //校验数据的格式和数据的正确性
        int start = i + 2;
        List<String> animals = new LinkedList<>();
        while (start < strs.length && strs[start] != null && !strs[start].equals("")) {
          String animalKey = checkAnimalDataFormat(strs[start]);
          if (animalKey.equals(errorData)) {
            return invalidFormat;
          }
          String data[] = strs[start].split("\\s+");
          if (map.containsKey(animalKey)) {
            //已经有这个动物了，需要检查数据正确
            Animal animal = map.get(animalKey);
            if (!(animal.getIncreX() + animal.getPreX() == Integer.valueOf(data[1])) ||
                !(animal.getIncreY() + animal.getPreY() == Integer.valueOf(data[2]))) {
              return conflictFound + strs[i];
            }
            animal.setPreX(Integer.valueOf(data[1]));
            animal.setPreY(Integer.valueOf(data[2]));
            animal.setIncreX(Integer.valueOf(data[3]));
            animal.setIncreY(Integer.valueOf(data[4]));
            animal.setFirstAppear(false);
            map.put(animalKey, animal);
          } else {
            //还未有这个动物，第一次放，没有增量，否则数据错误
            if (data.length != 3) {
              return conflictFound + strs[i];
            }
            Animal animal = new Animal();
            animal.setId(data[0]);
            animal.setPreX(Integer.valueOf(data[1]));
            animal.setPreY(Integer.valueOf(data[2]));
            animal.setFirstAppear(true);
            map.put(animalKey, animal);
          }
          animals.add(animalKey);
          start++;
        }

        //验证本次数据没有问题后，尝试看Id是否与UUID相同
        if (strs[i].equals(id)) {
          StringBuilder sb = new StringBuilder();
          for (String animal : animals) {
            Animal ani = map.get(animal);
            String aniId = ani.getId();
            String preX = String.valueOf(ani.getPreX());
            String preY = String.valueOf(ani.getPreY());
            sb.append(aniId).append(" ").append(preX).append(" ").append(preY);

            boolean isFirst = ani.isFirstAppear();
            if (!isFirst) {
              sb.append(" ").append(String.valueOf(ani.getIncreX())).append(" ").append(String.valueOf(ani.getIncreY()));
            }
            sb.append("\n");
          }
          return sb.toString().trim();
        }
        //新的起点
        i = start;
      }
    }

    return invalidFormat;

  }

  private String checkAnimalDataFormat(String s) {

    String str[] = s.split("\\s+");
    int len = str.length;
    //长度只能是3和5
    if (len != 3 && len != 5) {
      return errorData;
    }

    //后面的数得是数值
    for (int i = 1; i < len; i++) {
      try {
        Integer.valueOf(str[i]);
      } catch (NumberFormatException e) {
        return errorData;
      }
    }
    return str[0];
  }

}


class Animal {

  /**
   * 唯一ID
   */
  private String id;
  /**
   * 前一个状态的X值
   */
  private int preX;
  /**
   * 前一个状态的Y值
   */
  private int preY;
  /**
   * 当前状态的X增量
   */
  private int IncreX;
  /**
   * 当前状态的Y增量
   */
  private int IncreY;

  /**
   * 是否第一次出现
   */
  private boolean isFirstAppear;

  /**
   * Getter和Setter方法
   */
  public boolean isFirstAppear() {
    return isFirstAppear;
  }

  public void setFirstAppear(boolean firstAppear) {
    isFirstAppear = firstAppear;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getPreX() {
    return preX;
  }

  public void setPreX(int preX) {
    this.preX = preX;
  }

  public int getPreY() {
    return preY;
  }

  public void setPreY(int preY) {
    this.preY = preY;
  }

  public int getIncreX() {
    return IncreX;
  }

  public void setIncreX(int increX) {
    IncreX = increX;
  }

  public int getIncreY() {
    return IncreY;
  }

  public void setIncreY(int increY) {
    IncreY = increY;
  }
}