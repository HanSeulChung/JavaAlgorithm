package com.codingtest.programmers.level3.퍼즐조각채우기;

import java.util.*;

public class Solution {
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static boolean[][] boardVisited;
  static boolean[][] tableVisited;
  static int size;
  static int answer = 0;
  List<List<int[]>> boardSegList = new ArrayList<>();
  List<List<int[]>> tableSegList = new ArrayList<>();

  public int solution(int[][] game_board, int[][] table) {
    size = game_board.length;
    boardVisited = new boolean[size][size];
    tableVisited = new boolean[size][size];

    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (game_board[r][c] == 0 && !boardVisited[r][c]) {
          bfs(game_board, r, c, 0, boardVisited, boardSegList);
        }
        if (table[r][c] == 1 && !tableVisited[r][c]) {
          bfs(table, r, c, 1, tableVisited, tableSegList);
        }
      }
    }

    checkSegList(boardSegList, tableSegList);
    return answer;
  }

  private void bfs(int[][] map, int startR, int startC, int trigger,boolean[][]  checkVisited ,List<List<int[]>> segList) {

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{startR, startC});
    checkVisited[startR][startC] = true;
    List<int[]> segment = new ArrayList<>();
    segment.add(new int[]{0, 0});

    while(!q.isEmpty()) {
      int[] cur = q.poll();
      int curR = cur[0];
      int curC = cur[1];
      for (int i = 0; i < 4; i++) {
        int nr = curR + dr[i];
        int nc = curC + dc[i];

        if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
        if (!checkVisited[nr][nc] && map[nr][nc] == trigger) {
          checkVisited[nr][nc] = true;
          q.add(new int[]{nr, nc});
          segment.add(new int[]{nr - startR, nc - startC});
        }
      }
    }
    segList.add(segment);
  }

  private void checkSegList(List<List<int[]>> boardSegList, List<List<int[]>> tableSegList) {

    boolean[] completeTableSegment = new boolean[tableSegList.size()];

    for (int i = 0; i < boardSegList.size(); i++) {
      List<int[]> checkBoardSeg = boardSegList.get(i);
      for (int j = 0; j < tableSegList.size(); j++) {
        if (completeTableSegment[j] ||
            checkBoardSeg.size() != tableSegList.get(j).size()) continue;
        List<int[]> checkTableSeg = tableSegList.get(j);
        boolean rotateCheck = rotate(checkBoardSeg, checkTableSeg);
        if (rotateCheck) {

          System.out.println(checkTableSeg.size());
          answer += checkTableSeg.size();
          completeTableSegment[j] = true;
          break;
        }
      }
    }
  }

  private boolean rotate(List<int[]> checkBoardSeg, List<int[]> checkTableSeg) {
    checkBoardSeg.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    for (int i = 0; i < 4; i++) {
      checkTableSeg.sort((o1, o2) -> {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
      });

      int baseR = checkTableSeg.get(0)[0];
      int baseC = checkTableSeg.get(0)[1];

      for (int j = 0; j < checkTableSeg.size(); j++) {
        checkTableSeg.get(j)[0] -= baseR;
        checkTableSeg.get(j)[1] -= baseC;
      }

      boolean isCheck = true;
      for (int j = 0; j < checkTableSeg.size(); j++) {
        int[] board_check = checkBoardSeg.get(j);
        int[] table_check = checkTableSeg.get(j);

        if (board_check[0] != table_check[0] || board_check[1] != table_check[1]) {
          isCheck = false;
          break;
        }
      }

      if (!isCheck) {
        for (int j = 0; j < checkTableSeg.size(); j++) {
          int tmp = checkTableSeg.get(j)[0] * -1;
          checkTableSeg.get(j)[0] = checkTableSeg.get(j)[1];
          checkTableSeg.get(j)[1] = tmp;
        }
      } else {
        return true;
      }
    }
    return false;
  }
}
