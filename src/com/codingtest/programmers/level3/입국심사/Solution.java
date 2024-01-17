package com.codingtest.programmers.level3.입국심사;

import java.util.*;

public class Solution {
  public long solution(int n, int[] times) {
    Arrays.sort(times);

    long minTime = 0;
    long maxTime = (long) times[times.length - 1] * n;
    long answer, midTime, sum;
    answer = midTime = sum = 0;

    while (minTime <= maxTime) {
      sum = 0;
      midTime = (minTime + maxTime) / 2;

      for (int time : times) {
        sum += midTime / time;
      }

      if (sum >= n) {
        answer = midTime;
        maxTime = midTime - 1;
      } else {
        minTime = midTime + 1;
      }
    }

    return answer;
  }
}