package com.codingtest.programmers.level2.하노이의탑;

import java.util.*;

public class Solution {
  List<int[] > answer;
  public int[][] solution(int n) {
    answer = new ArrayList<>();
    hanoi(n, 1, 2, 3);
    return answer.stream().toArray(int[][]::new);
  }

  private void hanoi(int n, int from, int by, int to) {
    if (n == 1) {
      answer.add(new int[]{from, to});
      return;
    }

    hanoi(n - 1, from, to, by);
    answer.add(new int[]{from, to});
    hanoi(n - 1, by, from, to);
  }
}
