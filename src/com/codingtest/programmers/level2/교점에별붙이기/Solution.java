package com.codingtest.programmers.level2.교점에별붙이기;

import java.util.*;

class Point {
  long x;
  long y;

  public Point(long x, long y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Point point = (Point) obj;
    return x == point.x && y == point.y;
  }


  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}

public class Solution {
  static long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE;
  static long maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;
  public String[] solution(int[][] line) {

    List<Point> pointList = new ArrayList<>();

    for (int row = 0; row < line.length; row++) {
      calCrossPoint(row, line, pointList);
    }

    long xLength = maxX - minX + 1;
    long yLength = maxY - minY + 1;
    char[][] board = new char[(int)yLength][(int)xLength];
    for (int row = 0; row < yLength; row++) {
      for (int col = 0; col < xLength; col++) {
        board[(int)row][(int)col] = '.';
      }
    }

    for (Point point : pointList) {
      board[(int)(maxY - point.y)][(int)(point.x - minX)] = '*';
    }

    String[] answer = new String[board.length];
    for (int row = 0; row < yLength; row++) {
      answer[row] = new String(board[row]);
    }

    return answer;
  }

  private void calCrossPoint(int row, int[][] line, List<Point> pointList) {

    int[] row1 = line[row];
    long A = row1[0], B = row1[1], E = row1[2];

    for (int i = row + 1; i < line.length; i++) {
      int[] row2 = line[i];
      long C = row2[0], D = row2[1], F = row2[2];
      double slope = A * D - B * C;
      if ((int) slope == 0) {
        continue;
      }

      double x = (B * F - E * D) / slope;
      double y = (E * C - A * F) / slope;

      if (x != (long) x || y != (long) y) {
        continue;
      }

      Point newPoint = new Point((long) x, (long) y);
      if (!pointList.contains(newPoint)) {
        pointList.add(newPoint);
        minX = Math.min(minX, newPoint.x);
        maxX = Math.max(maxX, newPoint.x);
        minY = Math.min(minY, newPoint.y);
        maxY = Math.max(maxY, newPoint.y);
      }
    }
  }
}
