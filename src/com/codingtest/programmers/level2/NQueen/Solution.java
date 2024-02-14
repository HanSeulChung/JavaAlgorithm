package com.codingtest.programmers.level2.NQueen;

public class Solution {
  static int[] board;
  static int answer = 0;
  public int solution(int n) {
    board = new int[n];
    putQueens(0, n);
    return answer;
  }

  private void putQueens(int depth, int n) {
    if (depth == n) {
      answer++;
      return;
    }

    for (int i = 0; i < n; i++) {
      board[depth] = i;
      if (isPossible(depth)) {
        putQueens(depth + 1, n);
      }
    }
  }

  private boolean isPossible(int depth) {
    for (int row = 0; row < depth; row++) {
      if (board[row] == board[depth]) {
        return false;
      }
      if (Math.abs(row - depth) == Math.abs(board[row] - board[depth])) {
        return false;
      }
    }
    return true;
  }
}
