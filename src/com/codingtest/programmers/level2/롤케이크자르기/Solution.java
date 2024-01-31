package com.codingtest.programmers.level2.롤케이크자르기;

import java.util.*;
public class Solution {
  public int solution(int[] topping) {
    int answer = 0;
    Map<Integer, Integer> soo = new HashMap<>();
    Map<Integer, Integer> brother = new HashMap<>();
    int p = topping.length - 1;
    brother.put(topping[p], 1);
    for (int idx = 0; idx < p; idx++) {
      soo.put(topping[idx], soo.getOrDefault(topping[idx], 0) + 1);
    }

    if (soo.keySet().size() == brother.keySet().size()) {
      answer++;
    }

    while(p > 0) {
      p--;
      brother.put(topping[p], brother.getOrDefault(topping[p], 0) + 1);
      soo.put(topping[p], soo.getOrDefault(topping[p], 0) - 1);
      if (soo.get(topping[p]) == 0) {
        soo.remove(topping[p]);
      }
      if (soo.keySet().size() == brother.keySet().size()) {
        answer++;
      }
    }

    return answer;
  }
}
