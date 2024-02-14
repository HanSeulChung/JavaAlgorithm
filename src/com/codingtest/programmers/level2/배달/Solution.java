package com.codingtest.programmers.level2.배달;

public class Solution {
  private static int INF = 500001;

  public int floydwarshall(int N, int[][] road, int K) {
    int answer = 1;
    int[][] map = new int[N][N];
    map = initMap(N, road);

    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }
    for (int col = 1; col < N; col++) {
      if (map[0][col] <= K) {
        answer++;
      }
    }
    return answer;
  }

  public int dijkstra(int N, int[][] road, int K) {
    int answer = 1;
    int[][] map = new int[N][N];
    map = initMap(N, road);

    int[] dist = new int[N];
    for (int idx = 0; idx < N; idx++) {
      dist[idx] = map[0][idx];
    }

    boolean[] visited = new boolean[N];
    visited[0] = true;

    for (int i = 0; i < N; i++) {
      int min_idx = 0;
      int min_value = INF;
      for (int j = 1; j < N; j++) {
        if (!visited[j] && dist[j] < min_value) {
          min_value = dist[j];
          min_idx = j;
        }
      }

      visited[min_idx] = true;

      for (int j = 1; j < N; j++) {
        if (dist[j] > dist[min_idx] + map[min_idx][j]) {
          dist[j] = dist[min_idx] + map[min_idx][j];
        }
      }
    }

    for (int col = 1; col < N; col++) {
      if (dist[col] <= K) {
        answer++;
      }
    }
    return answer;
  }

  private int[][] initMap (int N, int[][] road) {
    int[][] map = new int[N][N];

    for (int row = 0; row < N; row++) {
      for (int col = 0; col < N; col++) {
        if (row == col) {
          continue;
        }
        map[row][col] = INF;
      }
    }

    for (int[] perRoad : road) {
      int row = perRoad[0] - 1;
      int col = perRoad[1] - 1;
      if (map[row][col] > perRoad[2]) {
        map[row][col] = perRoad[2];
        map[col][row] = perRoad[2];
      }
    }
    return map;
  }
}
