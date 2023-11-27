package com.codingtest.programmers.PCCP기출문제;

public class P9 {
  static int[] dh = {0, 0, 1, -1};
  static int[] dw = {1, -1, 0, 0};

  public int solution(String[][] board, int h, int w) {
    int answer = 0;
    int H = board.length;
    int W = board[0].length;

    for (int i = 0; i < 4; i++) {
      int searchH = h + dh[i];
      int searchW = w + dw[i];

      if (searchH < 0|| searchH >= H || searchW < 0 || searchW >= W) {
        continue;
      }

      if (board[h][w].equals(board[searchH][searchW])) {
        answer++;
      }
    }

    return answer;
  }
}
