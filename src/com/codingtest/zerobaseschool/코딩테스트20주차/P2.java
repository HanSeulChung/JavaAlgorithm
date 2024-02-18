package com.codingtest.zerobaseschool.코딩테스트20주차;

import java.util.*;

public class P2 {
  public int solution(int[][] x, int[][] y) {
    int answer = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] xArray : x) {
      map.put(xArray[0], xArray[1]);
    }

    for (int[] yArray : y) {
      if (map.containsKey(yArray[0])) {
        answer += yArray[1] * map.get(yArray[0]);
      }
    }
    return answer;
  }
}
