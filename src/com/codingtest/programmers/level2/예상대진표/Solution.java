package com.codingtest.programmers.level2.예상대진표;

public class Solution {
  public int solution(int n, int a, int b) {
    int answer = 0;

    while (true) {
      a = (a + 1) / 2;
      b = (b + 1) / 2;

      answer++;
      if (a == b) {
        break;
      }
    }

    return answer;
  }
}
