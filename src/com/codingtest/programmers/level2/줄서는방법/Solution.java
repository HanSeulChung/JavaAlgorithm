package com.codingtest.programmers.level2.줄서는방법;

import java.util.*;
public class Solution {
  public int[] solution(int n, long k) {
    int[] answer = new int[n];

    long f = 1;
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      numbers.add(i);
      f *= i;
    }

    k--;
    int idx = 0;
    while (n > 0) {
      f /= (n--);
      answer[idx++] = numbers.remove((int) (k / f));
      k %= f;
    }
    return answer;
  }
}
