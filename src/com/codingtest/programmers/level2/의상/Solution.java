package com.codingtest.programmers.level2.의상;

import java.util.*;

public class Solution {
  public int solution(String[][] clothes) {
    int answer = 0;
    Map<String, Set<String>> clothesMap = new HashMap<>();
    for (String[] oneClothes : clothes) {
      if (!clothesMap.containsKey(oneClothes[1])) {
        clothesMap.put(oneClothes[1], new HashSet<>(Collections.singletonList(oneClothes[0])));
      }
      clothesMap.get(oneClothes[1]).add(oneClothes[0]);
    }

    answer = countCases(clothesMap);

    return answer;
  }

  private int countCases(Map<String, Set<String>> clothesMap) {
    int cnt = 1;
    for (Set<String> value : clothesMap.values()) {
      cnt *= (value.size() + 1);
    }

    return cnt - 1;
  }

  public int solutionInteger(String[][] clothes) {
    int answer = 0;
    Map<String, Integer> clothesMap = new HashMap<>();
    for (String[] oneClothes : clothes) {
      clothesMap.put(oneClothes[1], clothesMap.getOrDefault(oneClothes[1], 0) + 1);
    }

    answer = countCasesInteger(clothesMap);

    return answer;
  }

  private int countCasesInteger(Map<String, Integer> clothesMap) {
    int cnt = 1;
    for (Integer value : clothesMap.values()) {
      cnt *= value + 1;
    }

    return cnt - 1;
  }
}