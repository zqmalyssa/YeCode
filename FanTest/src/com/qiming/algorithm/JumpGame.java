package com.qiming.algorithm;

public class JumpGame {

  public static void main(String[] args) {
    int[] arrInt = new int[]{2,3,1,1,4,2,1};
    System.out.println(new JumpGame().jump(arrInt));
  }

  public int jump(int[] nums) {
    //小于等于1的都不需要跳
    int lengths = nums.length;
    if(lengths <= 1){
      return 0;
    }
    int reach = 0;  //当前能走的最远距离
    int nextreach = nums[0];
    int step = 0;  //需要步数
    for(int i = 0;i<lengths;i++){
      //贪心算法核心：这一步是不是可以比上一步得到更多步数，可以则取最新的路线。
      nextreach = Math.max(i+nums[i],nextreach);
      if(nextreach >= lengths-1) return (step+1);
      if(i == reach){
        step++;
        reach = nextreach;
      }
    }
    return step;
  }

}
