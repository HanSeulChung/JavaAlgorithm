package com.codingtest.programmers.level2.테이블해시함수;

import java.util.*;

public class Solution {

  public int solution(int[][] data, int col, int row_begin, int row_end) {
    int answer = 0;
    int row_begin_idx = row_begin - 1;
    int row_end_idx = row_end - 1;

    Comparator<int[]> customComparator = (a, b) -> {
      // col - 1 번째 열 비교
      int compareResult = Integer.compare(a[col - 1], b[col - 1]);

      // 두 번째 열이 같은 경우 첫 번째 열 비교
      if (compareResult == 0) {
        return Integer.compare(b[0], a[0]);
      }

      return compareResult;
    };

    // 정의한 Comparator를 사용하여 정렬
    Arrays.sort(data, customComparator);


    for (int i = row_begin_idx; i <= row_end_idx; i++) {
      int dividIdx = i + 1;
      int S = Arrays.stream(data[i])
          .map(value -> value % dividIdx)
          .sum();

      answer ^= S;
    }

    return answer;
  }
}
