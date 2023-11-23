package com.codingtest.programmers.level2.순위검색;

import java.util.*;

public class Solution {
  static Map<String, List<Integer>> map;

  public void makeQueryCase(String[] infoArr, String str, int cnt) {
    if (cnt == 4) {
      if (!map.containsKey(str)) {
        List<Integer> list = new ArrayList<Integer>();
        map.put(str, list);
      }
      map.get(str).add(Integer.parseInt(infoArr[4]));
      return;
    }

    makeQueryCase(infoArr, str + "-", cnt + 1);
    makeQueryCase(infoArr, str + infoArr[cnt], cnt + 1);
  }

  public int binarySearch(String key, int score) {
    List<Integer> list = map.get(key);
    int start = 0, end = list.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (list.get(mid) < score)
        start = mid + 1;
      else
        end = mid - 1;
    }

    return list.size() - start;
  }

  public int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];
    map = new HashMap<>();

    for(String infoStr : info) {
      String[] infoArr = infoStr.split(" ");
      makeQueryCase(infoArr, "", 0);
    }

    for (String key : map.keySet()) {
      Collections.sort(map.get(key));
    }

    for (int i = 0; i < query.length; i++) {
      query[i] = query[i].replaceAll(" and ", "");
      String[] qArr = query[i].split(" ");
      int score = Integer.parseInt(qArr[1]);
      answer[i] = map.containsKey(qArr[0]) ?
          binarySearch(qArr[0], Integer.parseInt(qArr[1])) : 0;
    }
    return answer;
  }
}

