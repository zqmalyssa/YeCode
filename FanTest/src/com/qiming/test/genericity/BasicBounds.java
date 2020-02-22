package com.qiming.test.genericity;

import java.awt.Color;

/**
 * 单边界和多边界
 */

interface HasColor {
  java.awt.Color getColor();
}

class Colored <T extends HasColor>{
  T item;
  public Colored( T item) { this.item = item; }
  T getItem() {return item;}
  //有了边界 允许调用getColor()方法
  Color color(){ return item.getColor();}
}

class Dimension { public int x, y, z;}

//多边界 类要放在第一个 接口放在后面
//class ColoredDimension<T extends HasColor & Dimension>
class ColoredDimension <T extends Dimension & HasColor>{
  //...
}

interface Wight{int wight();}

//拥有多个边界的泛型类  多边界只能有一个具体类  但是可以有多个接口
class Solid <T extends Dimension & HasColor & Wight>{
  T item;
  public Solid(T item) { this.item = item; }
  T getItem() { return item;}
  Color color(){ return item.getColor();}
  int getX() {return item.x; }
  int getY() {return item.y; }
  int getZ() {return item.z; }
  int weight() {return item.wight(); }
}

class Bounded extends Dimension implements HasColor, Wight{
  public int wight() { return 0; }
  public Color getColor() { return null;}
}

public class BasicBounds {
  public static void main(String[] args) {
    Solid<Bounded> solid = new Solid<>(new Bounded());
    solid.color();
    solid.getX();
    solid.weight();
  }
}
