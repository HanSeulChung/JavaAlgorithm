package com.codingtest.programmers.PCCP기출문제;

/**
 * Lv1
 * 데이터 분석
 */

import java.util.*;

public class P10 {


  public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

    Map<String, Integer> map = new HashMap<>();
    map.put("code", 0);
    map.put("date", 1);
    map.put("maximum", 2);
    map.put("remain", 3);

    List<int[]> validList = new ArrayList<>();

    int keyIdx = -1;
    if (map.containsKey(ext)) {
      keyIdx = map.get(ext);
    }

    for (int[] d : data) {
      if (d[keyIdx] < val_ext) {
        validList.add(d);
      }
    }

    int[][] answer = validList.stream().toArray(int[][]::new);

    Arrays.sort(answer, (o1, o2) -> o1[map.get(sort_by)] - o2[map.get(sort_by)]);
    return answer;
  }
}
