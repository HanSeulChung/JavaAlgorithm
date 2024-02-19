package com.codingtest.programmers.level2.캐시;

import java.util.*;

public class Solution {
  public int solution(int cacheSize, String[] cities) {
    int answer = 0;

    if (cacheSize == 0) {
      return cities.length * 5;
    }

    Queue<String> paging = new LinkedList<>();

    for (String city : cities) {
      if (paging.isEmpty()) {
        answer += 5;
        paging.offer(city.toLowerCase());
        continue;
      }

      if (paging.contains(city.toLowerCase())) {
        answer += 1;
        paging.remove(city.toLowerCase());
        paging.offer(city.toLowerCase());
      } else {
        if (paging.size() == cacheSize) {
          paging.poll();
        }
        answer += 5;
        paging.offer(city.toLowerCase());
      }
    }

    return answer;
  }
}
