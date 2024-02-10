package com.codingtest.programmers.level2.더맵게;

import java.util.*;

public class Solution {
  public int solution(int[] scoville, int K) {

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      return o1 - o2;
    });

    for (int food : scoville) {
      pq.offer(food);
    }

    int cnt = 0;
    while(pq.size() >= 2) {
      int firstFood = pq.poll();
      if (firstFood >= K) {
        break;
      }
      int secondFood = pq.poll();
      pq.offer(firstFood + secondFood * 2);
      cnt++;
    }

    if(pq.peek() < K) {
      return -1;
    }

    return cnt;
  }
}
