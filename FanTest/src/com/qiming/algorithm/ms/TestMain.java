package com.qiming.algorithm.ms;

public class TestMain {

  public static void main(String[] args) {

    int []test1 = {1, 2, 5, 4, 3}; //yes
    int []test2 = {1, 2, 3, 4, 5}; //yes
    int []test3 = {1, 2, 4, 5, 3}; //no
    int []test4 = {2, 1, 4, 5, 3}; //no
    new TestMain().print(test1);
    new TestMain().print(test2);
    new TestMain().print(test3);
    new TestMain().print(test4);


  }

  public void print(int nums[]) {

    if (nums.length < 2) {
      System.out.println("Yes");
    }

    int indexMin = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i+1] < nums[i]) {
        indexMin = i + 1;
      }
    }

    if (indexMin == 0) {
      System.out.println("Yes");
      return;
    }
    boolean isRightNeed = true;
    if (indexMin == nums.length - 1) {
      isRightNeed = false;
    }

    int leftIndex = indexMin - 1;
    int rightIndex = 0;
    if (isRightNeed) {
      rightIndex = indexMin + 1;
    }

    while (nums[leftIndex] > nums[indexMin]) {
      if ((leftIndex - 1 >= 0) && nums[leftIndex] > nums[leftIndex - 1] && nums[leftIndex - 1] > nums[indexMin]) {
        System.out.println("No");
        return;
      }
      leftIndex--;
    }

    if (isRightNeed) {
      while (nums[rightIndex] < nums[indexMin]) {
        if ((rightIndex + 1 <= nums.length - 1) && nums[rightIndex] < nums[rightIndex+1] && nums[rightIndex+1] < nums[indexMin] ) {
          System.out.println("No");
          return;
        }
        rightIndex++;
      }
    }


    System.out.println("Yes");

  }

}
