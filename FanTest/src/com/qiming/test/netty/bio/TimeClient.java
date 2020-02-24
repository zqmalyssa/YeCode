package com.qiming.test.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端向服务端发送"QUERY TIME ORDER"指令获取当前时间，用到普通IO
 *
 */
public class TimeClient {

  public static void main(String[] args) {

    int port = 8080;

    if (args != null && args.length > 0) {
      port = Integer.valueOf(args[0]);
    }

    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;

    try {
      socket = new Socket("127.0.0.1", port);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      out.println("QUERY TIME ORDER"); //注意是println哦
      System.out.println("Send order 2 server succeed.");
      String resp = in.readLine();
      System.out.println("Now is : " + resp);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //注意in的close是要try catch的，out不需要，还有细节关闭的顺序
      if (out != null) {
        out.close();
        out = null;
      }

      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        socket = null;
      }
    }

  }

}
