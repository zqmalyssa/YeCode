package com.qiming.test.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * BIO的服务端，接收客户端发来的请求，用到普通IO
 *
 */
public class TimeServer {

  public static void main(String[] args) {

    int port = 8080;
    if (args != null && args.length > 0) {
      port = Integer.valueOf(args[0]);
    }

    ServerSocket server = null;
    try {
      server = new ServerSocket(port);
      System.out.println("The time server is start in port: " + port);
      Socket socket = null;
      while (true) {
        socket = server.accept();
        new Thread(new TimeServerHandler(socket)).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (server != null) {
        System.out.println("The time server close");
        try {
          server.close();
          server = null;
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }


  }

}

class TimeServerHandler implements Runnable {

  private Socket socket;

  public TimeServerHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {

    BufferedReader in = null;
    PrintWriter out = null;

    try {
      in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      out = new PrintWriter(this.socket.getOutputStream(), true);

      String currentTime = null;
      String body = null;

      while (true) {
        body = in.readLine();
        if (body == null) {
          break;
        }
        System.out.println("The time server receive order: " + body);
        currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        out.println(currentTime);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //注意in的close是要try catch的，out不需要，还有细节关闭的顺序
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (out != null) {
        out.close();
        out = null;
      }

      if (this.socket != null) {
        try {
          this.socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        this.socket = null;
      }
    }


  }
}