package com.codingtest.programmers.level5.사라지는발판;

public class Solution {
  static int R;
  static int C;
  static int[][] g_board;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  public int solution(int[][] board, int[] aloc, int[] bloc) {
    R = board.length;
    C = board[0].length;
    g_board = new int[R][C];
    g_board = board;
    return cal(aloc[0], aloc[1], bloc[0], bloc[1]);
  }

  private int cal(int arow, int acol, int brow, int bcol) {
    if (g_board[arow][acol] == 0) return 0;

    g_board[arow][acol] = 0;

    int ret = 0;
    for (int i = 0; i < 4; i++) {
      int nrow = arow + dr[i];
      int ncol = acol + dc[i];
      if (nrow < 0 || nrow >= R || ncol < 0 || ncol >= C) continue;
      if (g_board[nrow][ncol] == 0) continue;

      int cnt = 1 + cal(brow, bcol, nrow, ncol);

      if (cnt % 2 == 0) {
        if (ret % 2 == 0) {
          ret = Math.max(ret, cnt);
        } else {
          ret = ret;
        }
      } else {
        if (ret % 2 == 0) {
          ret = cnt;
        } else {
          ret = Math.min(ret, cnt);
        }
      }
    }
    g_board[arow][acol] = 1;

    return ret;
  }
}
