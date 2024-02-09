package com.codingtest.programmers.level2.타겟넘버;

public class Solution {
  static int answer;
  public int solution(int[] numbers, int target) {
    answer = 0;

    dfs(numbers, 0, 0, target, 0);
    return answer;
  }

  private void dfs(int[] number, int idx, int depth, int target, int sum) {
    if (depth == number.length) {
      if (sum == target) {
        answer++;
      }
      return;
    }

    sum += number[idx];
    dfs(number, idx + 1, depth + 1, target, sum);
    sum -= number[idx];
    number[idx] = -1 * number[idx];
    sum += number[idx];
    dfs(number, idx + 1, depth + 1, target, sum);
  }
}
