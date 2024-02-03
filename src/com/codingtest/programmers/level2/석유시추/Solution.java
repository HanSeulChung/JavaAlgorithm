package com.codingtest.programmers.level2.석유시추;

import java.util.*;

public class Solution {
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static final int Oil = 1;
  static int R, C;
  static Map<Integer, Integer> oilMassSum;
  static int maxSum;

  public int solution(int[][] land) {

    R = land.length;
    C = land[0].length;
    boolean[][] visited = new boolean[R][C];
    oilMassSum = new HashMap<>();
    maxSum = Integer.MIN_VALUE;

    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if(land[r][c] == Oil && !visited[r][c]) {
          List<Integer> colList =  new ArrayList<>();
          checkOilMass(land, r, c, colList, 1, visited);
        }
      }
    }

    return maxSum;
  }

  private void checkOilMass(int[][] land, int r, int c, List<Integer> colList, int mass, boolean[][] visited) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{r, c});
    visited[r][c] = true;
    colList.add(c);

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      for (int d = 0; d < 4; d++) {
        int nextR = current[0] + dr[d];
        int nextC = current[1] + dc[d];

        if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C || land[nextR][nextC] == 0 && visited[nextR][nextC]) {
          continue;
        }

        if (!visited[nextR][nextC] && land[nextR][nextC] == Oil) {
          if (!colList.contains(nextC)) {
            colList.add(nextC);
          }
          queue.offer(new int[]{nextR, nextC});
          visited[nextR][nextC] = true;
          mass++;
        }
      }
    }
    saveOilMass(colList, mass);
  }

  private void saveOilMass(List<Integer> colList, int mass) {

    // for(int idx = 0; idx <  ... 로 하면 4번에서 시간초과가 뜸)
    for (int col : colList) {
      oilMassSum.put(col, oilMassSum.getOrDefault(col, 0) + mass);

      if (oilMassSum.get(col) > maxSum) {
        maxSum = oilMassSum.get(col);
      }
    }
  }
}
