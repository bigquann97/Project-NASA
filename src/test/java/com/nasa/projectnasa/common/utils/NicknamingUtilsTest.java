package com.nasa.projectnasa.common.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class NicknamingUtilsTest {

  public static void main(String[] args) {

    List<String> prefix = List.of("가", "하하", "호호", "라라");
    List<String> suffix = List.of("마마마", "미디디", "가무ㅜ우");

    for (int i = 0; i < 1000; i++) {

      String pre = prefix.get((int) (Math.random() * prefix.size()));
      String suf = suffix.get((int) (Math.random() * suffix.size()));
      int num = (int) (Math.random() * 100);

      StringBuilder sb = new StringBuilder();
      sb.append(pre);
      sb.append(suf);
      sb.append(num);

      System.out.println(sb.toString());

    }


  }

}