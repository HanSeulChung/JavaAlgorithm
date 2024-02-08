package com.codingtest.programmers.level2.구명보트;

import java.util.Arrays;
public class Solution {
  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);

    int left = 0;
    int right = people.length - 1;

    int sum = 0;
    while (left < right) {
      sum = people[left] + people[right];

      if (sum > limit) {
        right--;
      } else {
        right--;
        left++;
      }
      answer++;
    }

    if (left == right) {
      answer++;
    }
    return answer;
  }
}
