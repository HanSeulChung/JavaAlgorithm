package com.codingtest.programmers.level2.연속된수열의합의개수;

import java.util.*;
import java.util.stream.Collectors;

// 구현, 원 수열
public class Solution {
  public int solution(int[] elements) {
    int n = elements.length;
    Set<Integer> sumSet = new HashSet<>();
    sumSet.addAll(Arrays.stream(elements).boxed().collect(Collectors.toList()));

    int start = 2;
    while(start <= n) {
      for (int i = 0; i < n; i++) {
        int value = 0;
        for (int j = i; j < i + start; j++) {
          value += elements[j % n];
        }
        sumSet.add(value);
      }
      start++;
    }
    return sumSet.size();
  }
}
