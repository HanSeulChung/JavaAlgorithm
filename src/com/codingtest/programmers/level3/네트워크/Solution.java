package com.codingtest.programmers.level3.네트워크;

import java.util.*;

public class Solution {
  List<List<Integer>> networks = new ArrayList<>();
  boolean[] visited;

  public int solution(int n, int[][] computers) {
    int answer = 0;
    visited = new boolean[n];
    for (int i = 0; i < computers.length; i++) {
      networks.add(new ArrayList<>());
      for (int j = 0; j < computers[0].length; j++) {
        if (i == j) continue;
        if (computers[i][j] == 1) {
          networks.get(i).add(j);
        }
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (visited[i]) continue;

      q.add(i);
      while (!q.isEmpty()) {
        int cur = q.poll();

        if (visited[cur]) continue;
        if (networks.get(cur).size() == 0) continue;

        visited[cur] = true;
        for (int neighbor : networks.get(cur)) {
          if (!visited[neighbor]) {
            q.add(neighbor);
          }
        }
      }
      answer++;
    }
    return answer;
  }
}
