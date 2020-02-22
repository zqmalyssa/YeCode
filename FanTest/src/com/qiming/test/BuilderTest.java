package com.qiming.test;

public class BuilderTest {

  private final int size;

  private final int fat;

  private final int sodium;

  private final int service;

  public static class Builder {
    private final int size;
    private final int fat;

    private int sodium = 0;
    private int service = 0;

    public Builder(int size, int fat) {
      this.size = size;
      this.fat = fat;
    }

    public Builder sodium(int sodium) {
      sodium = sodium;
      return this;
    }

    public Builder service(int service){
      service = service;
      return this;
    }

    public BuilderTest build(){
      return new BuilderTest(this);
    }
  }

  private BuilderTest(Builder builder){
    size = builder.size;
    fat = builder.fat;
    sodium = builder.sodium;
    service = builder.service;
  }

  public static void main(String args[]) {
    BuilderTest test = new BuilderTest.Builder(5,10).service(11).sodium(12).build();
  }

}
