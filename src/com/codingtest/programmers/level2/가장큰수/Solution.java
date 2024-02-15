package com.codingtest.programmers.level2.가장큰수;

import java.util.Arrays;

public class Solution {

  public String solution(int[] numbers) {
    String[] numberStrings = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      numberStrings[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(numberStrings, (a, b) -> {
      String order1 = a + b;
      String order2 = b + a;
      return order2.compareTo(order1);
    });

    StringBuilder sb = new StringBuilder();
    for (String numStr : numberStrings) {
      sb.append(numStr);
    }
    return sb.charAt(0) == '0' ? "0" : sb.toString();
  }
}