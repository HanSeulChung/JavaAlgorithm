package com.codingtest.programmers.level3.산모양타일링;

public class Solution {
  static final int MOD = 10007;
  public int solution(int n, int[] tops) {
    int[][] mountain = new int[n][2];

    if (tops[0] == 0) {
      mountain[0][0] = 2;
      mountain[0][1] = 1;
    } else {
      mountain[0][0] = 3;
      mountain[0][1] = 1;
    }

    for (int idx = 1; idx < n; idx++) {
      if (tops[idx] == 0) {
        mountain[idx][0] = mountain[idx - 1][0] * 2 + mountain[idx - 1][1];
      } else {
        mountain[idx][0] = mountain[idx - 1][0] * 3
            + mountain[idx - 1][1] * 2;
      }
      mountain[idx][1] = mountain[idx - 1][0] + mountain[idx - 1][1];
      mountain[idx][0] %= MOD;
      mountain[idx][1] %= MOD;
    }
    return (mountain[n - 1][0] + mountain[n - 1][1]) % MOD;
  }
}