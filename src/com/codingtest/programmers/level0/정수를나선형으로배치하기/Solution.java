package com.codingtest.programmers.level0.정수를나선형으로배치하기;

public class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int value = 1;
        int row = 0;
        int col = 0;
        int direction = 0;

        while (value <= n * n) {
            answer[row][col] = value++;

            if (direction == 0) {
                if (col == n - 1 || answer[row][col + 1] != 0) {
                    row++;
                    direction = 1;
                } else {
                    col++;
                }
            } else if (direction == 1) {
                if (row == n - 1 || answer[row + 1][col] != 0) {
                    col--;
                    direction = 2;
                } else {
                    row++;
                }
            } else if (direction == 2) {
                if (col == 0 || answer[row][col - 1] != 0) {
                    row--;
                    direction = 3;
                } else {
                    col--;
                }
            } else if (direction == 3) {
                if (row == 0 || answer[row - 1][col] != 0) {
                    col++;
                    direction = 0;
                } else {
                    row--;
                }
            }
        }


        return answer;
    }
}
