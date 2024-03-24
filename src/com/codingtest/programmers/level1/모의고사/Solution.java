package com.codingtest.programmers.level1.모의고사;

import java.util.*;

public class Solution {
  public int[] solution(int[] answers) {
    List<Integer> answer = new ArrayList<>();
    int[] one = new int[]{1, 2, 3, 4, 5};
    int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int totalCnt = 0;
    int oneCnt = 0;
    int twoCnt = 0;
    int threeCnt = 0;
    while (totalCnt < answers.length) {
      if (answers[totalCnt % answers.length] == one[totalCnt % one.length]) {
        oneCnt++;
      }
      if (answers[totalCnt % answers.length] == two[totalCnt % two.length]) {
        twoCnt++;
      }
      if (answers[totalCnt % answers.length] == three[totalCnt % three.length]) {
        threeCnt++;
      }

      totalCnt++;
    }

    boolean checkthird = false;
    Map<Integer, List<Integer>> map = new HashMap<>();
    map.put(oneCnt, new ArrayList<>());
    map.get(oneCnt).add(1);
    if (map.containsKey(twoCnt)) {
      map.get(twoCnt).add(2);
    } else {
      if (oneCnt < twoCnt) {
        map.remove(oneCnt);
        map.put(twoCnt, new ArrayList<>());
        map.get(twoCnt).add(2);
        checkthird = true;
      }
    }

    if (map.containsKey(threeCnt)) {
      map.get(threeCnt).add(3);
    } else if (checkthird) {
      if (twoCnt < threeCnt) {
        return new int[]{3};
      }
    } else {
      if (oneCnt < threeCnt) {
        return new int[]{3};
      }
    }

    List<Integer> mapKey = new ArrayList<>(map.keySet());

    return map.get(mapKey.get(0)).stream().mapToInt(i -> i).toArray();
  }
}
