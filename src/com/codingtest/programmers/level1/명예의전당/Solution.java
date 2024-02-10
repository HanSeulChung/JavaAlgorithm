package com.codingtest.programmers.level1.명예의전당;

import java.util.*;

public class Solution {
  public int[] solution(int k, int[] score) {
    int[] answer = new int[score.length];
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      return o1 - o2;
    });
    for (int idx = 0; idx < score.length; idx++) {
      answer[idx] = getMinScore(idx, score, pq, k);
    }
    return answer;
  }
  private int getMinScore(int idx, int[] score, PriorityQueue<Integer> pq, int k) {
    if (pq.size() == k && pq.peek() >= score[idx]) {
      return pq.peek();
    }
    if (pq.size() == k && pq.peek() < score[idx]) {
      pq.poll();
      pq.offer(score[idx]);
      return pq.peek();
    }
    pq.offer(score[idx]);
    return pq.peek();
  }

}
