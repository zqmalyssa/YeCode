package com.qiming.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceImpl implements Performance{

  @Override
  public void perform() {
    System.out.println("good job");
  }
}
