package com.codingtest.programmers.level3.양과늑대;

public class Solution {
  static final int SHEEP = 0;
  static final int WOLF = 1;
  static int maxSheepCnt;

  public int solution(int[] info, int[][] edges) {
    maxSheepCnt = 0;
    boolean[] visited = new boolean[info.length];
    dfs(0, 0, 0, visited, info, edges);
    return maxSheepCnt;
  }

  private void dfs(int idx, int sheepCnt, int wolfCnt, boolean[] visited, int[] info, int[][] edges) {
    visited[idx] = true;
    if (info[idx] == SHEEP) {
      sheepCnt++;
    } else {
      wolfCnt++;
    }

    if (sheepCnt <= wolfCnt) {
      return;
    }

    maxSheepCnt = Math.max(maxSheepCnt, sheepCnt);

    for (int[] edge : edges) {
      if (visited[edge[0]] && !visited[edge[1]]) {
        boolean[] nextVisited = visited.clone();
        dfs(edge[1], sheepCnt, wolfCnt, nextVisited, info, edges);
      }
    }
  }
}
