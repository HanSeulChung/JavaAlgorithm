package com.codingtest.programmers.level2.행렬테두리회전하기;

public class Solution {
  static int[][] map;
  public void print(int[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();

    }
  }
  public int rotate(int x1, int y1, int x2, int y2) {
    // x1, y1 자리에 있는 값 저장
    int tmp = map[x1][y1];
    // 초기 작은 값 셋팅
    int min = tmp;

    // 왼쪽 모서리 회전
    for (int i = x1; i < x2; i++) {
      min = Math.min(min, map[i][y1]);
      map[i][y1] = map[i + 1][y1];
    }
    // 아래쪽 모서리 회전
    for (int j = y1; j < y2; j++) {
      min = Math.min(min, map[x2][j]);
      map[x2][j] = map[x2][j + 1];
    }
    // 오른쪽 모서리 회전
    for (int i = x2; i > x1; i--) {
      min = Math.min(min, map[i][y2]);
      map[i][y2] = map[i - 1][y2];
    }
    // 위쪽 모서리 회전
    for (int j = y2; j > y1; j--) {
      min = Math.min(min, map[x1][j]);
      map[x1][j] = map[x1][j - 1];
    }

    map[x1][y1 + 1] = tmp;
    return min;
  }

  public int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = new int[queries.length];

    // map 셋팅
    map = new int[rows][columns];
    int init = 1;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        map[i][j] = init++;
      }
    }

    int idx = 0;
    for (int[] query: queries) {
      answer[idx++] =
          rotate(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
    }
    return answer;
  }
}
