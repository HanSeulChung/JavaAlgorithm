package com.codingtest.programmers.level2.귤고르기;

import java.util.*;
public class Solution {
  public int solution(int k, int[] tangerine) {
    int answer = 0;
    Arrays.sort(tangerine);
    PriorityQueue<Integer> sumQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

    int cnt = 1;
    for (int idx = 0; idx < tangerine.length - 1; idx++) {
      if (tangerine[idx] == tangerine[idx + 1]) {
        cnt++;
      } else {
        if (cnt >= k) {
          return 1;
        }
        sumQ.offer(cnt);
        cnt = 1;
      }
    }
    sumQ.offer(cnt);

    int kSum = 0;
    while(kSum < k){
      kSum += sumQ.poll();
      answer++;
    }
    return answer;
  }
}
