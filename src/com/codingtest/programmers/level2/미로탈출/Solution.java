package com.codingtest.programmers.level2.미로탈출;

import java.util.*;

public class Solution {
  char[][] map;
  boolean[][] visited;
  int[] di = {1, 0, -1, 0};
  int[] dj = {0, 1, 0, -1};

  public int solution(String[] maps) {
    int idx = 0;
    map = new char[maps.length][maps[0].length()];
    for (String m : maps) {
      map[idx++] = m.toCharArray();
    }

    int[] start = new int[2];
    int[] lever = new int[2];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] == 'S') {
          start = new int[]{i ,j};
        } else if (map[i][j] == 'L') {
          lever = new int[]{i, j};
        }
      }
    }

    int startToLever = bfs(start, 'L');
    if (startToLever == -1) {
      return -1;
    }
    int leverToEnd = bfs(lever, 'E');
    if (leverToEnd == -1) {
      return -1;
    }

    return startToLever + leverToEnd;
  }

  private int bfs(int[] start, char target) {
    visited = new boolean[map.length][map[0].length];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{start[0], start[1], 0});
    visited[start[0]][start[1]] = true;

    int count = 0;
    while(!queue.isEmpty()) {
      int[] cur = queue.poll();
      visited[cur[0]][cur[1]] = true;
      count = cur[2];
      if (map[cur[0]][cur[1]] == target) {
        return count;
      }
      for (int idx = 0; idx < di.length; idx++) {
        int nextI = cur[0] + di[idx];
        int nextJ = cur[1] + dj[idx];

        if (nextI >= 0 && nextI < map.length && nextJ >= 0 && nextJ < map[0].length
            && map[nextI][nextJ] != 'X' && !visited[nextI][nextJ]) {
          visited[nextI][nextJ] = true;
          queue.offer(new int[]{nextI, nextJ, count + 1});
        }
      }
    }
    return -1;
  }
}
