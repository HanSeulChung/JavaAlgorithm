package com.codingtest.programmers.level2.쿼드압축후개수새기;

public class Solution {
  static int zeroSum = 0;
  static int oneSum = 0;

  public int[] solution(int[][] arr) {
    int[] answer = new int[2];
    makeQuad(arr, 0, 0, arr.length);
    answer[0] = zeroSum;
    answer[1] = oneSum;
    return answer;
  }

  private void makeQuad(int[][] arr, int x, int y, int size) {
    if (zip(arr, x, y, size)) {
      if (arr[x][y] == 1) {
        oneSum++;
      } else {
        zeroSum++;
      }
      return;
    }

    int nextSize = size / 2;

    makeQuad(arr, x, y, nextSize);
    makeQuad(arr, x + nextSize, y, nextSize);
    makeQuad(arr, x, y + nextSize, nextSize);
    makeQuad(arr, x + nextSize, y + nextSize, nextSize);
  }

  private boolean zip(int[][] arr, int x, int y, int size) {
    int val = arr[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (arr[i][j] != val) {
          return false;
        }
      }
    }
    return true;
  }
}
