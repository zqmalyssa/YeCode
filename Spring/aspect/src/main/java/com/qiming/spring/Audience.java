package com.qiming.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
  @Pointcut("execution(* com.qiming.spring.Performance.perform(..))") //定义切点(何处)
  public void performance() {};

  @Before("performance()")		//定义通知(何时，做什么)
  public void silenceCellPhones() {
    System.out.println("Silencing cell phones");
  }

  @Before("performance()")
  public void takeSeats() {
    System.out.println("Taking seats");
  }

  @AfterReturning("performance()")
  public void applause() {
    System.out.println("CLAP CLAP CLAP!!!");
  }

  @AfterThrowing("performance()")
  public void demandRefund() {
    System.out.println("Demanding a refund");
  }
}
