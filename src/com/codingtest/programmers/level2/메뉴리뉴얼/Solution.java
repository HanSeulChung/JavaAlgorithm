package com.codingtest.programmers.level2.메뉴리뉴얼;

import java.util.*;
import java.util.Map.Entry;

public class Solution {
  static Map<String, Integer> map;

  public String[] solution(String[] orders, int[] course) {
    List<String> list = new ArrayList<>();

    for (int idx = 0; idx < orders.length; idx++) {
      char[] charArr = orders[idx].toCharArray();
      Arrays.sort(charArr);
      orders[idx] = String.valueOf(charArr);
    }


    for (int courseLength : course) {
      map = new HashMap<>();
      int max = Integer.MIN_VALUE;
      for (int idx = 0; idx < orders.length; idx++) {
        if (courseLength <= orders[idx].length()) {
          StringBuilder sb = new StringBuilder();
          combi(orders[idx], sb, 0, 0, courseLength);
        }
      }

      for (Entry<String, Integer> entry : map.entrySet()) {
        max = Math.max(max, entry.getValue());
      }

      for (Entry<String, Integer> entry : map.entrySet()) {
        if (max >= 2 && entry.getValue() == max) {
          list.add(entry.getKey());
        }
      }
    }

    String[] answer = list.toArray(new String[0]);
    Arrays.sort(answer);
    return answer;
  }

  private void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
    if (cnt == n) {
      map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
      return;
    }

    for(int i = idx ; i< str.length();i++){
      sb.append(str.charAt(i));
      combi(str, sb, i + 1, cnt + 1, n);
      sb.delete(cnt, cnt + 1);
    }
  }
}
