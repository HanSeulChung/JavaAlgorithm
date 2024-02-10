package com.codingtest.programmers.level1.과일장수;

import java.util.*;

public class Solution {
  public int solution(int k, int m, int[] score) {
    int answer = 0;

    Arrays.sort(score);
    int n = score.length / m;
    int cnt = 0;
    int idx = score.length - 1;
    while (idx >= 0) {
      if (cnt == n) {
        break;
      }
      int min = score[idx];
      for (int i = 1; i < m; i++) {
        idx--;
        if (i == m - 1) {
          min = score[idx];
          answer += min;
          idx--;
        }
      }
      cnt++;
    }

    return answer * m;
  }
}
