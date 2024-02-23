package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4485 {
  static class Node {
    int r;
    int c;
    int cost;

    public Node(int r, int c, int cost) {
      this.r = r;
      this.c = c;
      this.cost = cost;
    }
  }

  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[][] dist;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    N = 1;
    int idx = 1;

    while(true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0) {
        br.close();
        break;
      }

      map = new int[N][N];
      visited = new boolean[N][N];
      dist = new int[N][N];
      for (int row = 0; row < N; row++) {
        st = new StringTokenizer(br.readLine());
        for (int col = 0; col < N; col++) {
          map[row][col] = Integer.parseInt(st.nextToken());
          dist[row][col] = Integer.MAX_VALUE;
        }
      }

      System.out.printf("Problem %d: %d\n", idx++, bfs());
    }
    br.close();
  }
  private static int bfs() {
    PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
      return n1.cost - n2.cost;
    });

    pq.add(new Node(0, 0, map[0][0]));
    visited[0][0] = true;
    dist[0][0] = map[0][0];

    while(!pq.isEmpty()) {
      Node curNode = pq.poll();
      for (int i = 0; i < 4; i++) {
        int nextR = curNode.r + dr[i];
        int nextC = curNode.c + dc[i];

        if (isValid(nextR, nextC) && !visited[nextR][nextC]
         && dist[nextR][nextC] > dist[curNode.r][curNode.c] + map[nextR][nextC]) {
          visited[nextR][nextC] = true;
          dist[nextR][nextC] = curNode.cost + map[nextR][nextC];
          pq.add(new Node(nextR, nextC, dist[nextR][nextC]));
        }

      }
    }
    return dist[N - 1][N - 1];
  }

  private static boolean isValid(int nextR, int nextC) {
    return (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N);
  }
}
