package com.codingtest.programmers.level2.두개이하로다른비트;

import java.util.*;

public class Solution {
  public long[] solution(long[] numbers) {
    List<Long> answer = new ArrayList<>();

    for (long number : numbers) {
      if (number % 4 == 3) {
        answer.add(checkMinValue(number));
      } else {
        answer.add(number + 1);
      }
    }

    return answer.stream().mapToLong(i -> i).toArray();
  }

  private String makeBit(long number) {
    StringBuilder bit = new StringBuilder();

    while (number > 0) {
      bit.insert(0, number % 2);
      number /= 2;
    }

    return bit.toString();
  }

  private long makeLong(String bit) {
    long number = 0L;

    for (int idx = bit.length() - 1; idx >= 0; idx--) {
      if (bit.charAt(idx) == '1') {
        int powNumber = bit.length() - (idx + 1);
        number += Math.pow(2, powNumber);
      }
    }

    return number;
  }

  private long checkMinValue(long originalNumber) {
    String originalBit = makeBit(originalNumber);
    if (!originalBit.contains("0")) {
      originalBit = "10" + originalBit.substring(1);
    } else {
      int idx = originalBit.lastIndexOf("0");
      originalBit = originalBit.substring(0, idx) + "10" + originalBit.substring(idx + 2);
    }

    return makeLong(originalBit);
  }
}