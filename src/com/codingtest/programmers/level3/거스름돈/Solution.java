package com.codingtest.programmers.level3.거스름돈;

import java.util.*;


public class Solution {
  static final int MOD = 1_000_000_007;
  public int solution(int n, int[] money) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;

    Arrays.sort(money);
    for (int haveMoney : money) {
      for (int idx = haveMoney; idx <= n; idx++) {
        dp[idx] += dp[idx - haveMoney] % MOD;
      }
    }

    return dp[n] % MOD;
  }
}
