package com.codingtest.programmers.level2.양궁대회;

public class Solution {
  static int[] answer = new int[11];
  static int[] info;
  static int max = Integer.MIN_VALUE;

  public int[] solution(int n, int[] info) {
    this.info = info;

    lionArchery(0, n, new int[11]);

    if (max <= 0) {
      return new int[]{-1};
    }

    return answer;
  }

  private void lionArchery(int depth, int n, int[] result) {
    if (depth == n) {
      int diff = sumCal(info, result);
      if (diff > max) {
        max = diff;
        answer = result.clone();
      } else if (diff == max) {
        checkIncludeMin(result);
      }
      return;
    }

    for (int idx = 0; idx < result.length && result[idx] <= info[idx]; idx++){
      result[idx] += 1;
      lionArchery(depth + 1, n, result);
      result[idx] -= 1;
    }
  }

  private int sumCal(int[] info, int[] result) {
    int peachSum = 0;
    int lionSum = 0;
    for (int idx = 0; idx < info.length; idx++) {
      if (info[idx] == 0 && result[idx] == 0) {
        continue;
      }
      if (info[idx] >= result[idx]) {
        peachSum += (10 - idx);
      } else {
        lionSum += (10 - idx);
      }
    }

    int diff = lionSum - peachSum;
    if (diff <= 0) {
      return -1;
    }
    return diff;
  }

  private void checkIncludeMin(int[] result) {
    for (int idx = result.length - 1; idx >= 0; idx--) {
      if (answer[idx] < result[idx]) {
        answer = result.clone();
        return;
      } else if (answer[idx] > result[idx]) {
        return;
      }
    }
  }
}
