package com.codingtest.programmers.level2.HINDEX;

import java.util.Arrays;

public class Solution {
  public int solution(int[] citations) {
    int answer = 0;
    Arrays.sort(citations);
    for(int idx = 0; idx < citations.length; idx++) {
      int citationCnt = citations.length - idx;
      if (citations[idx] >= citationCnt) {
        answer = citationCnt;
        break;
      }
    }
    return answer;
  }
}
