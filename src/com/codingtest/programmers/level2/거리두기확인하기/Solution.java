package com.codingtest.programmers.level2.거리두기확인하기;

import java.util.*;

public class Solution {
  public int[] solution(String[][] places) {
    int[] answer = new int[places.length];

    int idx = 0;
    for (String[] place : places) {
      boolean isOk = true;

      for (int row = 0; row < place.length; row++) {
        for (int col = 0; col < place[0].length(); col++) {
          if (place[row].charAt(col) == 'P') {
            if (!bfs(row, col, place)) {
              isOk = false;
            }
          }
        }
      }
      answer[idx++] = isOk ? 1 : 0;
    }
    return answer;
  }

  private boolean bfs(int row, int col, String[] place) {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, -1, 0, 1};

    Queue<int[] > q = new LinkedList<>();
    q.add(new int[]{row, col});

    while(!q.isEmpty()) {
      int[] currSeat = q.poll();
      for (int d = 0; d < 4; d++) {
        int nextR = currSeat[0] + dr[d];
        int nextC = currSeat[1] + dc[d];

        if (nextR < 0 || nextR >= 5 || nextC < 0 || nextC >= 5 || (nextR == row && nextC == col)) {
          continue;
        }
        int manhattanDistance = Math.abs(nextR - row) + Math.abs(nextC - col);
        if (place[nextR].charAt(nextC) == 'P' && manhattanDistance <= 2) {
          return false;
        } else if (place[nextR].charAt(nextC) == 'O' && manhattanDistance < 2) {
          q.add(new int[]{nextR, nextC});
        }
      }
    }
    return true;
  }
}
