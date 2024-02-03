package com.codingtest.programmers.level2.요격시스템;

import java.util.*;

// 그리디

public class Solution {
  public int solutionPQ(int[][] targets) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o2[0] - o1[0];
      }

      return o1[1] - o2[1];
    });

    for (int[] target : targets) {
      pq.offer(target);
    }

    int[] missile = pq.poll();
    int answer = 1;
    while(!pq.isEmpty()) {
      if (missile[1] > pq.peek()[0]) {
        pq.poll();
      } else {
        missile = pq.poll();
        answer++;
      }
    }

    return answer;
  }
  public int solution(int[][] targets) {
    int answer = 0;

    Arrays.sort(targets, (o1, o2) -> { return o1[1]-o2[1]; });

    int last = -1;
    for (int[] target : targets) {
      if (last == -1) {
        answer++;
        last = target[1] - 1;
        continue;
      }

      if (last >= target[0] && last <= target[1]) continue;

      answer++;
      last = target[1] - 1;
    }

    return answer;
  }
}

