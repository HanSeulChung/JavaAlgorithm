package com.codingtest.programmers.level1.다트게임;

import java.util.*;
import java.util.regex.*;

public class Solution {
  private static int[] sum;

  public int solution(String dartResult) {
    sum = new int[3];

    Pattern p = Pattern.compile("(10|[0-9])([SDT][*#]?)");
    Matcher m = p.matcher(dartResult);
    int idx = 0;
    while(m.find()) {
      int numberGroup = Integer.parseInt(m.group(1));
      String characterGroup = m.group(2);
      sumPoint(numberGroup, characterGroup, idx++);
    }

    return sum[0] + sum[1] + sum[2];
  }

  private void sumPoint(int numberGroup, String characterGroup, int idx) {
    int presentSum = 0;
    if (characterGroup.charAt(0) == 'S') {
      presentSum += Math.pow(numberGroup, 1);
    } else if (characterGroup.charAt(0) == 'D') {
      presentSum += Math.pow(numberGroup, 2);
    } else {
      presentSum += Math.pow(numberGroup, 3);
    }

    if (characterGroup.length() == 2) {
      if (characterGroup.charAt(1) == '*') {
        if (idx > 0) {
          sum[idx - 1] *= 2;
        }
        presentSum *= 2;
      } else {
        presentSum *= -1;
      }
    }
    sum[idx] = presentSum;
  }
}
