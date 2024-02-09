package com.codingtest.programmers.level2.후보키;

import java.util.*;

public class Solution {
  static String[][] g_relation;
  static Set<String> colKey;
  public int solution(String[][] relation) {

    colKey = new HashSet<>();
    g_relation = relation;
    int n = relation[0].length;

    for (int kind = 1; kind <= n; kind++) {
      boolean[] visited = new boolean[n];
      dfs(0, 0, visited, kind);
    }
    return colKey.size();
  }

  private void dfs(int idx, int cnt, boolean[] visited, int kind) {
    if (cnt == kind) {
      String cols = "";
      for (int i = 0; i < visited.length; i++) {
        if (visited[i]) {
          cols += i;
        }
      }

      if (isPossibleKey(cols, visited)) {
        colKey.add(cols);
      }
      return;
    }

    if (idx >= visited.length) {
      return;
    }

    visited[idx] = true;
    dfs(idx + 1, cnt + 1, visited, kind);

    visited[idx] = false;
    dfs(idx + 1, cnt, visited, kind);
  }

  private boolean isPossibleKey(String cols, boolean[] visited) {
    for (String col : colKey) {
      if (cols.length() < col.length()) {
        continue;
      }

      if (cols.length() == col.length()) {
        if (Integer.parseInt(cols) <= Integer.parseInt(col)) {
          return false;
        }
      } else {
        boolean flag = true;
        for (int i = 0; i < col.length(); i++) {
          if (!cols.contains(col.charAt(i) + "")){
            flag = false;
          }
        }
        if (flag) {
          return false;
        }

      }
    }

    Set<String> sSet = new HashSet<>();
    for (String[] row : g_relation) {
      String s = "";
      for (int idx = 0; idx < visited.length; idx++) {
        if (visited[idx]) {
          s += row[idx];
        }
      }

      if (!sSet.contains(s)) {
        sSet.add(s);
      } else {
        return false;
      }
    }
    return true;
  }
}
