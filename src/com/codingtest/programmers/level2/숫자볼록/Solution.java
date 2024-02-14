package com.codingtest.programmers.level2.숫자볼록;

public class Solution {
  public int[] solution(long begin, long end) {
    int first = (int) begin;
    int last = (int) end;
    int[] answer = new int[last - first + 1];

    for (int now = first; now <= last; now++) {
      answer[now - first] = 1;

      for (int div = 2; div <= Math.sqrt(now); div++) {
        if (now % div == 0 ) {
          if (now / div <= 10000000) {
            answer[now - first] = now / div;
            break;
          } else {
            answer[now - first] = div;
          }
        }
      }
    }

    if (first == 1) {
      answer[0] = 0;
    }

    return answer;
  }
}