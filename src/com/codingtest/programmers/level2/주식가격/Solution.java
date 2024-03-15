package com.codingtest.programmers.level2.주식가격;

import java.util.Stack;

public class Solution {
  public int[] solution(int[] prices) {
    int length = prices.length;
    int[] answer = new int[length];

    Stack<Integer> indexs = new Stack<>();
    int idx = 0;
    indexs.push(idx);
    for (idx = 1; idx < length; idx++) {
      while (!indexs.empty() && prices[idx] < prices[indexs.peek()]) {
        int beginIdx = indexs.pop();
        answer[beginIdx] = idx - beginIdx;
      }
      indexs.push(idx);
    }

    idx--;
    while (!indexs.empty()) {
      int beginIdx = indexs.pop();
      answer[beginIdx] = idx - beginIdx;
    }

    return answer;
  }
  public int[] solutionWithOutStackQueue(int[] prices) {
    int length = prices.length;
    int[] answer = new int[length];
    answer[length - 1] = 0;
    for (int idx = length - 2; idx >= 0; idx--) {
      int value = prices[idx];
      int cnt = 0;
      for (int j = idx; j < length - 1; j++) {
        if (value <= prices[j]) {
          cnt++;
        } else {
          break;
        }
      }
      answer[idx] = cnt;
    }
    return answer;
  }
}
