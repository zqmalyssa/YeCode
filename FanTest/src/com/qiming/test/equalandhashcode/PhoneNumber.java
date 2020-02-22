package com.qiming.test.equalandhashcode;


import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
  private int areaCode;
  private int prefix;
  private int lineNumber;

  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNumber = lineNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PhoneNumber that = (PhoneNumber) o;

    if (areaCode != that.areaCode) return false;
    if (prefix != that.prefix) return false;
    return lineNumber == that.lineNumber;
  }

  @Override
  public int hashCode() {
    int result = areaCode;
    result = 31 * result + prefix;
    result = 31 * result + lineNumber;
    return result;
  }

  /**
   * 输出是qiming，但如果注释掉equals方法，则返回就变成null了
   * @param args
   */
  public static void main(String[] args){
    Map<PhoneNumber,String> phoneNumberStringMap = new HashMap<PhoneNumber,String>();
    phoneNumberStringMap.put(new PhoneNumber(123, 456, 7890), "qiming");
    System.out.println(phoneNumberStringMap.get(new PhoneNumber(123, 456, 7890)));

  }
}

