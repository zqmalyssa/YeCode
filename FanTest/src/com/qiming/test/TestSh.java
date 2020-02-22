package com.qiming.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestSh {

  public static void main(String args[]) {
//    StringBuffer paras = new StringBuffer();
//    Arrays.stream(para).forEach(x -> paras.append(x).append(" "));
    try {
      boolean execCmd = false;
      String cmd = "", shpath = "";
      if (execCmd) {
        // 命令模式
        shpath = "echo";
      } else {
        //脚本路径
        shpath = "/root/test.sh";

      }
//      cmd = shpath + " " + paras.toString();
      cmd = shpath;

      //解决脚本没有执行权限
      ProcessBuilder builder = new ProcessBuilder("/bin/chmod", "755", shpath);
      Process process = builder.start();
      process.waitFor();

      Process ps = Runtime.getRuntime().exec(cmd);
      ps.waitFor();

      BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
      StringBuffer sb = new StringBuffer();
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
      String result = sb.toString();
      System.out.println(result);

    } catch (
        Exception e) {
      e.printStackTrace();
    }
  }
}
