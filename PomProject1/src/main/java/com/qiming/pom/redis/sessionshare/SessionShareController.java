package com.qiming.pom.redis.sessionshare;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionShareController {

  @Value("${server.port}")
  private int port;

  @RequestMapping(value = "/session/set", method = RequestMethod.POST)
  public Object setSession(HttpSession session, String name) {
    session.setAttribute("name", name);
    return "ok";
  }

  @RequestMapping(value = "/session/get", method = RequestMethod.GET)
  public Object getSession(HttpSession session) {
    Object name = session.getAttribute("name");
    return "port: " + port + ", name: " + name;
  }

}
