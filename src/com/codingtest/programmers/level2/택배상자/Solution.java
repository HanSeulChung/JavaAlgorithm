package com.codingtest.programmers.level2.택배상자;

import java.util.*;

public class Solution {
  public int solution(int[] order) {
    int answer = 0;
    int n = order.length;

    Stack<Integer> stack = new Stack<>();
    int currentIndex = 0;

    for (int i = 1; i <= n; i++) {
      stack.push(i);

      while (!stack.isEmpty() && currentIndex < n && stack.peek() == order[currentIndex]) {
        stack.pop();
        currentIndex++;
      }
    }

    // stack에 남아있는 상자는 보조 컨테이너에 넣은 상자들이므로 answer에 추가
    answer = stack.size();

    return n - answer;
  }
}
