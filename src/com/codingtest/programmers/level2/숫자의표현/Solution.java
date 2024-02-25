package com.codingtest.programmers.level2.숫자의표현;

public class Solution {
  public int solution(int n) {
    int answer = 0;
    int[] numbers = new int[n + 2];
    int number = 1;
    for (int idx = 1; idx <= n; idx++) {
      numbers[idx] = number++;
    }

    int left = 1;
    int right = 1;
    int sum = 0;
    while(right <= n + 1) {

      if (sum > n) {
        sum -= numbers[left++];
      } else if (sum < n) {
        sum += numbers[right++];
      }

      if (sum == n) {
        answer++;
        sum += numbers[right++];
      }
    }
    return answer;
  }
}
