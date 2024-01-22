package com.codingtest.programmers.level2.연속된부분수열의합;

// 투포인터
public class Solution {
  public int[] solution(int[] sequence, int k) {
    int n = sequence.length;
    int[] answer = new int[]{0, n};

    int p1 = 0;
    int p2 = 1;
    int sum = sequence[p1];

    while (p1 < p2) {
      if (sum == k) {
        checkLength(p1, p2, answer);
        sum -= sequence[p1++];
      } else if (sum > k) {
        sum -= sequence[p1++];
      } else if (p2 < n) {
        sum += sequence[p2++];
      } else {
        break;
      }

    }
    return answer;
  }

  private void checkLength(int p1, int p2, int[] answer){
    if (p2 - p1 - 1 < answer[1] - answer[0]) {
      answer[0] = p1;
      answer[1] = p2 - 1;
    }
  }
}
