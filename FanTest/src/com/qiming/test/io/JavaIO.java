package com.qiming.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO {

  /**
   * 用字节流写文件
   * @throws IOException
   */
  public static void writeByteToFile() throws IOException {
    String hello= new String( "hello word!");
    byte[] byteArray= hello.getBytes();
    File file= new File( "d:/test.txt");
    //因为是用字节流来写媒介，所以对应的是OutputStream
    //又因为媒介对象是文件，所以用到子类是FileOutputStream
    OutputStream os= new FileOutputStream(file);
    os.write(byteArray);
    os.close();
  }

  /**
   * 用字节流读文件
   * @throws IOException
   */
  public static void readByteFromFile() throws IOException{
    File file= new File( "d:/test.txt");
    byte[] byteArray= new byte[(int)file.length()];
    //因为是用字节流来读媒介，所以对应的是InputStream
    //又因为媒介对象是文件，所以用到子类是FileInputStream
    InputStream is= new FileInputStream(file);
    int size= is.read(byteArray);
    System. out.println( "大小:"+size +";内容:" +new String(byteArray));
    is.close();
  }

  /**
   * 用字符流写文件
   * @throws IOException
   */
  public static void writeCharToFile() throws IOException{
    String hello= new String( "hello word!");
    File file= new File( "d:/test.txt");
    //因为是用字符流来读媒介，所以对应的是Writer，又因为媒介对象是文件，所以用到子类是FileWriter
    Writer os= new FileWriter(file);
    os.write(hello);
    os.close();
  }


  /**
   * 用字符流读文件
   * @throws IOException
   */
  public static void readCharFromFile() throws IOException{
    File file= new File( "d:/test.txt");
    //因为是用字符流来读媒介，所以对应的是Reader
    //又因为媒介对象是文件，所以用到子类是FileReader
    Reader reader= new FileReader(file);
    char [] byteArray= new char[(int) file.length()];
    int size= reader.read(byteArray);
    System. out.println( "大小:"+size +";内容:" +new String(byteArray));
    reader.close();
  }


  /**
   * 字节流转换成字符流
   * @throws IOException
   */
  public static void convertByteToChar() throws IOException{
    File file= new File( "d:/test.txt");
    //获得一个字节流
    InputStream is= new FileInputStream(file);
    //把字节流转换为字符流，其实就是把字符流和字节流组合的结果。
    Reader reader= new InputStreamReader(is);
    char [] byteArray= new char[(int) file.length()];
    int size= reader.read(byteArray);
    System. out.println( "大小:"+size +";内容:" +new String(byteArray));
    is.close();
    reader.close();
  }


  /**
   * 用缓冲字节流读文件
   * @throws IOException
   */
  public static void readByBufferedInputStream() throws IOException {
    File file = new File( "d:/test.txt");
    byte[] byteArray = new byte[(int) file.length()];
    //可以在构造参数中传入buffer大小
    InputStream is = new BufferedInputStream(new FileInputStream(file),2*1024);
    int size = is.read(byteArray);
    System.out.println( "大小:" + size + ";内容:" + new String(byteArray));
    is.close();
  }

  /**
   * 用缓冲字符流读文件
   * @throws IOException
   */
  public static void readByBufferedReader() throws IOException {
    File file = new File( "d:/test.txt");
    // 在字符流基础上用buffer流包装，也可以指定buffer的大小
    Reader reader = new BufferedReader(new FileReader(file),2*1024);
    char[] byteArray = new char[(int) file.length()];
    int size = reader.read(byteArray);
    System. out.println( "大小:" + size + ";内容:" + new String(byteArray));
    reader.close();
  }



}
