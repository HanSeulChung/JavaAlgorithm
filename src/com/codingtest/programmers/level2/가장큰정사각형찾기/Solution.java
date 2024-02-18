package com.codingtest.programmers.level2.가장큰정사각형찾기;

public class Solution {
  public int solution(int[][] board){
    int maxLen = 0;
    int R = board.length + 1;
    int C = board[0].length + 1;

    int[][] map = new int[R][C];
    for (int row = 1; row < R; row++) {
      for (int col = 1; col < C; col++) {
        if (board[row - 1][col - 1] != 0) {
          int tmp = Math.min(map[row - 1][col - 1],
              Math.min(map[row - 1][col], map[row][col - 1]));
          map[row][col] = tmp + 1;
          maxLen = Math.max(maxLen, tmp + 1);
        }
      }
    }
    return maxLen * maxLen;
  }
}
