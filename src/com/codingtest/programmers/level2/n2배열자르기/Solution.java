package com.codingtest.programmers.level2.n2배열자르기;

public class Solution {
  public int[] solution(int n, long left, long right) {
    int[] answer = new int[(int)(right - left) + 1];

    int idx = 0;
    for (long i = left; i <= right; i++) {
      long row = i / n;
      long col = i % n;
      answer[idx++] = Math.max((int)row, (int)col) + 1;
    }
    return answer;
  }
}
