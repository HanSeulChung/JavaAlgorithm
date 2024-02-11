package com.codingtest.programmers.level2.다리를지나는트럭;

import java.util.*;

public class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < bridge_length; i++) {
      q.offer(0);
    }

    int idx = 0;
    int currWeight = 0;
    while (idx < truck_weights.length) {
      currWeight -= q.poll();
      answer++;

      if (currWeight + truck_weights[idx] <= weight) {
        currWeight += truck_weights[idx];
        q.offer(truck_weights[idx++]);
      } else {
        q.offer(0);
      }
    }
    return answer + bridge_length;
  }
}
