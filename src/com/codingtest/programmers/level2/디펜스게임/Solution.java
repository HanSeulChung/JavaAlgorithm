package com.codingtest.programmers.level2.디펜스게임;

import java.util.*;

public class Solution {
  public int solution(int n, int k, int[] enemy) {
    int maxEnemys = enemy.length;
    int answer = maxEnemys;

    if (k >= maxEnemys) {
      return maxEnemys;
    }

//    int sumEnemys = Arrays.stream(enemy).sum();
//    if (sumEnemys <= n) {
//      return maxEnemys;
//    } -> 이게있으면 테스트 통과가 안됨. 왜지?

    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < maxEnemys; i++) {
      n -= enemy[i];
      pq.offer(enemy[i]);

      if (n < 0) {
        if (k > 0 && !pq.isEmpty()) {
          n += pq.poll();
          k--;
        } else {
          answer = i;
          break;
        }
      }
    }
    return answer;
  }
}
