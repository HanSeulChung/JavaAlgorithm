package com.codingtest.programmers.level2.무인도여행;

import java.util.*;

public class Solution {
  int[] dx = {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};
  boolean[][] visited;
  int n, m;

  public int[] solution(String[] maps) {
    List<Integer> answer = new ArrayList<>();
    n = maps.length;
    m = maps[0].length();

    for (String map : maps) {
      if (!map.replaceAll("X","").equals("")) {
        break;
      }
      return new int[] { -1};
    }
    char[][] charmap = new char[n][m];
    visited = new boolean[n][m];
    for (int idx = 0; idx < n; idx++) {
      charmap[idx] = maps[idx].toCharArray();
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && charmap[i][j] != 'X') {
          answer.add(bfs(i, j, charmap));
        }
      }
    }
    return answer.stream().mapToInt(i -> i).sorted().toArray();
  }

  private int bfs(int i, int j, char[][] charmap) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{i, j});
    visited[i][j] = true;
    int count = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currentX = current[0];
      int currentY = current[1];
      count += charmap[currentX][currentY] - '0';
      for (int d = 0; d < 4; d++) {
        int nextX = currentX + dx[d];
        int nextY = currentY + dy[d];

        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && charmap[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
          visited[nextX][nextY] = true;
          queue.offer(new int[]{nextX, nextY});

        }
      }
    }

    return count;
  }
}
