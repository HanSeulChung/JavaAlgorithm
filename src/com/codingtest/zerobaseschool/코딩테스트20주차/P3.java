package com.codingtest.zerobaseschool.코딩테스트20주차;

import java.util.*;

public class P3 {
  public int solution(int[][] activity) {
    int n = activity.length;
    Arrays.sort(activity, (a, b) -> Integer.compare(a[0], b[0]));

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      int startTime = activity[i][0];
      int endTime = activity[i][1];
      if (!pq.isEmpty() && pq.peek() <= startTime) {
        pq.poll();
        pq.offer(endTime);
      } else {
        pq.offer(endTime);
      }
    }
    return pq.size();
  }
}
