package com.codingtest.programmers.level2.게임맵최단거리;

import java.util.*;

public class Solution {
  private static int[] dr = {1, 0, -1, 0};
  private static int[] dc = {0, 1, 0, -1};
  private static boolean[][] visited;

  public int solution(int[][] maps) {
    int answer = 0;
    visited = new boolean[maps.length][maps[0].length];
    answer = bfs(maps);

    return answer;
  }

  private int bfs(int[][] maps) {

    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(0, 0, 1));
    visited[0][0] = true;

    while (!q.isEmpty()) {
      Point curPoint = q.poll();
      for (int idx = 0; idx < 4; idx++) {
        int nextR = curPoint.r + dr[idx];
        int nextC = curPoint.c + dc[idx];

        if (nextR < 0 || nextR >= maps.length || nextC < 0 || nextC >= maps[0].length || maps[nextR][nextC] == 0) {
          continue;
        }

        if (nextR == maps.length - 1 && nextC == maps[0].length - 1) {
          return curPoint.cnt + 1;
        }

        if (!visited[nextR][nextC]) {
          visited[nextR][nextC] = true;
          q.offer(new Point(nextR, nextC, curPoint.cnt + 1));
        }
      }
    }
    return -1;
  }

  class Point {
    int r;
    int c;
    int cnt;

    public Point(int r, int c, int cnt) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
    }

    @Override
    public String toString() {
      return "Point r = " + r + ", c = " + c + ", cnt = " + cnt;
    }
  }
}
