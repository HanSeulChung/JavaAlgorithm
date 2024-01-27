package com.codingtest.programmers.level2.피로도;

public class Solution {
  boolean[] visited;
  int answer = 0;
  public int solution(int k, int[][] dungeons) {
    visited = new boolean[dungeons.length];

    dfs(0, dungeons, k);

    return answer;
  }
  private void dfs(int depth, int[][] dungeons, int k) {
    for (int i = 0; i < dungeons.length; i++) {
      if (visited[i] || k < dungeons[i][0]) {
        continue;
      }
      visited[i] = true;
      dfs(depth + 1, dungeons,  k - dungeons[i][1]);
      visited[i] = false;
    }
    answer = Math.max(depth, answer);
  }
}
