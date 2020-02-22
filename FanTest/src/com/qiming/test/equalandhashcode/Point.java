package com.qiming.test.equalandhashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果重写了equals而不重写hashcode的话，那么在用如HashMap和HashSet的时候就会有问题
 *
 *
 *
 */
public class Point {

  private int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    //不重写的情况
//    return super.hashCode();

    int result = Integer.hashCode(x);
    result = 31 * result + Integer.hashCode(y);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Point)) {
      return false;
    }
    Point point = (Point)obj;
    return this.x == point.x && this.y == point.y;
  }

  public static void main(String[] args) {

    Point p1 = new Point(1,2);
    Point p2 = new Point(1,2);
    System.out.println(p1.equals(p2));

    Map<Point, String> map = new HashMap<>();
    map.put(p1, "p1");
    //既然p1和p2相等，那么我get出来理应也是字符串p1，但是因为hashcode没有重写，将p1和p2放到了不同的哈希桶中了
    System.out.println(map.get(p2));
  }

}
