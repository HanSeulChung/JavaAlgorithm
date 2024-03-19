package com.codingtest.programmers.level4.사단고음;

public class Solution {
  static int totalCnt;

  public int solution(int n) {
    int addCnt = 0;
    totalCnt = 0;
    pitchProcess(addCnt, n);
    return totalCnt;
  }

  private void pitchProcess(int addCnt, int n) {
    if (n < 3 || Math.pow(3, addCnt/2) > n) {
      return;
    }

    if (n == 3) {
      if (addCnt == 2) totalCnt++;
        return;
    }


    if (n % 3 == 0 && addCnt >= 2) {
      pitchProcess(addCnt - 2, n/3);
    }
      pitchProcess(addCnt + 1, n - 1);
    }
}
