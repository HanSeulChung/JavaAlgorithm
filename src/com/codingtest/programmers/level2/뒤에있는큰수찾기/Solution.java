package com.codingtest.programmers.level2.뒤에있는큰수찾기;

import java.util.*;

public class Solution {
  public int[] solution(int[] numbers) {
    int n = numbers.length;
    int[] answer = new int[n];
    Arrays.fill(answer, -1);
    for (int idx = n - 2; idx >= 0; idx--) {
      for (int next = idx + 1; next < n; next++) {
        if (numbers[idx] == numbers[next] && answer[next] != -1) {
          answer[idx] = answer[next];
          break;
        } else if (numbers[idx] == numbers[next] && answer[next] == -1 ||
            numbers[idx] > numbers[next] && answer[next] == -1) {
          break;
        } else if (numbers[idx] < numbers[next]) {
          answer[idx] = numbers[next];
          break;
        }
      }
    }
    return answer;
  }

}
