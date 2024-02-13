package com.codingtest.programmers.level2.카펫;

public class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
    int row = 0;
    int col = 0;

    // row * 2 + 2 * (col - 2) = brown
    // row = brown/ 2 - col + 2
    // (row - 2) * (col - 2 ) = yellow
    // (col - brown / 2) * (col - 2) = - yellow
    // col^2 - (brown / 2 + 2) * col + yellow + brown = 0
    int b = - (brown / 2 + 2);
    int c = yellow + brown;

    int root = (int)Math.sqrt(Math.pow(b, 2) - 4 * c);
    b *= -1;
    col = (b + root) / 2;
    row = brown / 2 - (col - 2);
    answer[0] = row > col ? row : col;
    answer[1] = col < row ? col : row;
    return answer;
  }

  public int[] solution1(int brown, int yellow) {
    int[] answer = new int[2];
    int iAllNum = brown + yellow;
    int iHeight = 0;

    for (int iBrownWidth = 1; iBrownWidth < brown; iBrownWidth++) {
      iHeight = iAllNum/iBrownWidth;

      if((iBrownWidth - 2) * (iHeight - 2) == yellow) {
        answer[0] = iBrownWidth;
        answer[1] = iHeight;
      }
    }
    return answer;
  }
}
