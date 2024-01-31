package com.codingtest.programmers.level2.할인행사;

import java.util.*;
public class Solution {
  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    Map<String, Integer> map = new HashMap<>();
    for (int idx = 0; idx < want.length; idx++) {
      map.put(want[idx], number[idx]);
    }

    Map<String, Integer> dmap = new HashMap<>();
    for(int idx = 0; idx < 10; idx++) {
      dmap.put(discount[idx], dmap.getOrDefault(discount[idx], 0) + 1);
    }
    if (check(map, dmap)) {
      answer++;
    }

    for (int idx = 1; idx < discount.length - 9; idx++) {
      String prevKey = discount[idx - 1];
      int end = idx + 9;
      dmap.put(prevKey, dmap.getOrDefault(prevKey, 0) - 1);
      if (dmap.get(prevKey) == 0) {
        dmap.remove(prevKey);
      }
      dmap.put(discount[end], dmap.getOrDefault(discount[end], 0) + 1);
      if (check(map, dmap)){
        answer++;
      }
    }
    return answer;
  }

  private boolean check(Map<String, Integer> map, Map<String, Integer> dmap) {
    for (String key: dmap.keySet()) {
      if (!map.containsKey(key) || map.get(key) != dmap.get(key)) {
        return false;
      }
    }
    return true;
  }
}
