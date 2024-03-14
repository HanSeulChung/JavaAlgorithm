package com.codingtest.programmers.level2.프렌즈4블록;

public class Solution {
  static char[][] map;
  static int R;
  static int C;

  public int solution(int m, int n, String[] board) {
    int answer = 0;
    R = m;
    C = n;
    map = new char[R][C];
    int row = 0;
    for (String line : board) {
      map[row++] = line.toCharArray();
    }

    while (true) {
      int result = checkBlock();
      if (result == 0) {
        break;
      }
      drop();
      answer += result;
    }
    return answer;
  }

  private int checkBlock() {
    boolean[][] visited = new boolean[R][C];
    int cnt = 0;
    for (int r = 0; r < R - 1; r++){
      for (int c = 0; c < C - 1; c++) {
        if (map[r][c] != '0') {
          checkFour(r, c, visited);
        }
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (visited[i][j]) {
          map[i][j] = '0';
          cnt++;
        }
      }
    }
    return cnt;
  }

  private void checkFour(int r, int c, boolean[][] visited) {
    char block = map[r][c];
    for (int i = r; i < r + 2; i++) {
      for (int j = c; j < c + 2; j++) {
        if (map[i][j] != block) {
          return;
        }
      }
    }

    for (int i = r; i < r + 2; i++) {
      for (int j = c; j < c + 2; j++) {
        visited[i][j] = true;
      }
    }
  }

  private void drop() {
    for (int r = R - 1; r >= 0; r--) {
      for (int c = 0; c < C; c++) {
        if (map[r][c] == '0' && r - 1 > 0) {
          int remove = r;
          int fill = r - 1;
          while (fill >= 0) {
            if (map[fill][c] != '0') {
              map[remove][c] = map[fill][c];
              map[fill][c] = '0';
              break;
            }
            fill--;
          }
        }
      }
    }
  }
}
