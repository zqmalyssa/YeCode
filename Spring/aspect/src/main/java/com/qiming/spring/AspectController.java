package com.qiming.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
public class AspectController {

  @Autowired
  private PerformanceImpl p;

  @RequestMapping(value="/hello", method= RequestMethod.GET)
  public String hello() {
    p.perform();
    return "hello";
  }

  @RequestMapping(value="/hello2", method= RequestMethod.GET)
  public void hello2() {
    p.perform();
  }
}
