package com.codingtest.programmers.level3.여행경로;

import java.util.*;
public class Solution {
  static boolean[] isvisited;
  static List<String> list;

  public void dfs(int depth, String to, String path, String[][] tickets) {
    if (depth == tickets.length) {
      list.add(path);
      return;
    }

    for (int i = 0; i < tickets.length; i++) {
      if (!isvisited[i] && to.equals(tickets[i][0])) {
        isvisited[i] = true;
        dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
        isvisited[i] = false;
      }
    }
  }

  public String[] solution(String[][] tickets) {
    list = new ArrayList<>();
    isvisited = new boolean[tickets.length];

    dfs(0, "ICN", "ICN", tickets);

    Collections.sort(list);

    return list.get(0).split(" ");
  }
}