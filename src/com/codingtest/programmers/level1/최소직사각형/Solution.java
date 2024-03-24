package com.codingtest.programmers.level1.최소직사각형;

public class Solution {
  public int solution(int[][] sizes) {
    int maxR = Integer.MIN_VALUE;
    int maxC = Integer.MIN_VALUE;

    for (int idx = 0; idx < sizes.length; idx++) {
      if (sizes[idx][0] < sizes[idx][1]) {
        int tmp = sizes[idx][1];
        sizes[idx][1] = sizes[idx][0];
        sizes[idx][0] = tmp;
      }

      maxR = Math.max(maxR, sizes[idx][0]);
      maxC = Math.max(maxC, sizes[idx][1]);
    }

    int answer = maxR * maxC;

    return answer;
  }
}
