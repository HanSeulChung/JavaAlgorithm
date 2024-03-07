package com.codingtest.programmers.level3.합승택시요금;

import java.util.*;

public class Solution {
  private static final int MAX = 20000001;
  static int[][] board;
  static List<int[]> graph;
  static int N;

  public int solution_map(int n, int s, int a, int b, int[][] fares) {
    int answer = Integer.MAX_VALUE;
    N = n;
    board = new int[N + 1][N + 1];
    for (int[] fare : fares) {
      int u = fare[0];
      int v = fare[1];
      int cost = fare[2];
      board[u][v] = cost;
      board[v][u] = cost;
    }

    int[] togetherDist = dijkstra_map(s);
    int[] aDist = dijkstra_map(a);
    int[] bDist = dijkstra_map(b);

    for (int i = 1; i <= N; i++) {
      answer = Math.min(answer, togetherDist[i] + aDist[i] + bDist[i]);
    }
    return answer;
  }

  public int solution_graph(int n, int s, int a, int b, int[][] fares) {
    int answer = Integer.MAX_VALUE;
    N = n;

    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new int[N + 1]);
    }

    for (int[] fare : fares) {
      int u = fare[0];
      int v = fare[1];
      int cost = fare[2];
      graph.get(u)[v] = cost;
      graph.get(v)[u] = cost;
    }

    int[] togetherDist = dijkstra_graph(s);
    int[] aDist = dijkstra_graph(a);
    int[] bDist = dijkstra_graph(b);

    for (int i = 1; i <= N; i++) {
      answer = Math.min(answer, togetherDist[i] + aDist[i] + bDist[i]);
    }
    return answer;
  }

  private int[] dijkstra_graph(int start) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      return o1[1] - o2[1];
    });
    boolean[] visited = new boolean[N + 1];
    pq.add(new int[]{start, 0});

    int[] dist = new int[N + 1];
    Arrays.fill(dist, MAX);
    dist[start] = 0;

    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      int curLocation = cur[0];
      if (visited[curLocation]) {
        continue;
      }

      visited[curLocation] = true;
      int[] costs = graph.get(curLocation);
      for (int next = 1; next <= N; next++) {
        if (costs[next] == 0) {
          continue;
        }
        if (dist[next] > costs[next] + dist[curLocation]){
          dist[next] = costs[next] + dist[curLocation];
          pq.add(new int[]{next, dist[next]});
        }
      }
    }
    return dist;
  }
  private int[] dijkstra_map(int start) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      return o1[1] - o2[1];
    });
    boolean[] visited = new boolean[N + 1];
    pq.add(new int[]{start, 0});

    int[] dist = new int[N + 1];
    Arrays.fill(dist, MAX);
    dist[start] = 0;

    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      int curLocation = cur[0];
      if (visited[curLocation]) {
        continue;
      }

      visited[curLocation] = true;
      for (int next = 0; next <= N; next++) {
        if (board[curLocation][next] == 0) {
          continue;
        }

        if (dist[curLocation] + board[curLocation][next] < dist[next]) {
          dist[next] = dist[curLocation] + board[curLocation][next];
          pq.add(new int[]{next, dist[next]});
        }
      }
    }
    return dist;
  }
}
