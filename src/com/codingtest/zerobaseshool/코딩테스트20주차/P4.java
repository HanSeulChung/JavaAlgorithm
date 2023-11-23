package com.codingtest.zerobaseshool.코딩테스트20주차;

import java.util.*;

public class P4 {
  public String[] solution(int n) {
    List<String> result = findStrobogrammatic(n);
    Collections.sort(result);
    return result.toArray(new String[0]);
  }

  public List<String> findStrobogrammatic(int n) {
    return makeStrobogrammaticNumber(n, n);
  }

  public List<String> makeStrobogrammaticNumber(int n, int m) {
    if (n == 0) return new ArrayList<>(List.of(""));
    if (n == 1) return new ArrayList<>(List.of("0", "1", "8"));

    List<String> list = makeStrobogrammaticNumber(n - 2, m);
    List<String> result = new ArrayList<>();

    for (String s : list) {
      if (n != m) {
        result.add("0" + s + "0");
      }
      result.add("1" + s + "1");
      result.add("6" + s + "9");
      result.add("8" + s + "8");
      result.add("9" + s + "6");
    }

    return result;
  }
}
