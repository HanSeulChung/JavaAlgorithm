package com.codingtest.programmers.level3.금과은운반하기;

public class Solution {
  static final long MAX = ((long)(10e9 + 10e9) / 1L) * ((long)(10e5 * 2));

  public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
    long answer = MAX;
    int cityCnt = g.length;
    long start = 0;
    long end = MAX;

    while (start <= end) {
      long mid = (start + end) / 2;
      int gold = 0;
      int silver = 0;
      int total = 0;
      for (int idx = 0; idx < cityCnt; idx++) {
        int curGold = g[idx];
        int curSilver = s[idx];
        int curWeight = w[idx];
        long nowTime = t[idx];

        long curTime = mid % (nowTime * 2) < nowTime ? mid / (nowTime * 2) : mid / (nowTime * 2) + 1;

        gold += Math.min(curGold, curWeight * curTime);
        silver += Math.min(curSilver, curWeight * curTime);
        total += Math.min(curGold + curSilver, curWeight * curTime);
      }
      if (a <= gold && b <= silver && a + b <= total) {
        end = mid - 1;
        answer = Math.min(answer, mid);
      } else {
        start = mid + 1;
      }
    }
    return answer;
  }
}