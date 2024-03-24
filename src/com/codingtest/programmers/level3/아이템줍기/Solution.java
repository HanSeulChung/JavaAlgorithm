package com.codingtest.programmers.level3.아이템줍기;

import java.util.*;

public class Solution {
  static char[][] map;
  static final int max = 101;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static boolean[][] visited;
  static int answer;

  public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    map = new char[max][max];
    visited = new boolean[max][max];
    for (char[] mapRow : map) {
      Arrays.fill(mapRow, '0');
    }
    for (int[] oneRectangle : rectangle) {
      draw(oneRectangle[0] * 2, oneRectangle[1] * 2, oneRectangle[2] * 2, oneRectangle[3] * 2);
    }
    bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    return answer / 2;
  }

  private void draw(int x1, int y1, int x2, int y2) {
    for (int r = x1; r <= x2; r++) {
      for (int c = y1; c <= y2; c++) {
        if (r == x1 || r == x2 || c == y1 || c == y2) {
          if (map[r][c] == '2') {
            continue;
          }
          map[r][c] = '1';
          continue;
        }
        map[r][c] = '2';
      }
    }
  }

  private void bfs(int startR, int startC, int endR, int endC) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{startR, startC, 0});
    visited[startR][startC] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int cnt = cur[2];

      if (cur[0] == endR && cur[1] == endC) {
        answer = cnt;
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= max || nc < 0 || nc >= max) continue;
        if (!visited[nr][nc] && map[nr][nc] == '1') {
          q.add(new int[]{nr, nc, cnt + 1});
          visited[nr][nc] = true;
        }
      }
    }
  }
}
