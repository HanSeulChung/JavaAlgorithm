package com.codingtest.programmers.level1.기사단원의무기;

public class Solution {
  public int solution(int number, int limit, int power) {
    int answer = 0;
    int[] divisors = new int[number];

    for (int idx = 0; idx < number; idx++) {
      divisors[idx] = getDivisorCnt(idx + 1);
    }

    for (int divisor : divisors) {
      if (divisor > limit) {
        answer += power;
        continue;
      }

      answer += divisor;

    }
    return answer;
  }

  private int getDivisorCnt(int num) {
    int result = 0;

    for (int i = 1; i * i <= num; i++) {
      if (num == i * i) {
        result++;
      } else if (num % i == 0) {
        result += 2;
      }
    }
    return result;
  }

}
