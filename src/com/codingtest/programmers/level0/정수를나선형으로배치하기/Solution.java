package com.codingtest.programmers.level0.정수를나선형으로배치하기;

public class Solution {
    public int[][] solution1(int n) {
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

    public int[][] solution2(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int x = 0, y = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int direction = 0;

        while (num <= n * n) {
            answer[x][y] = num++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                direction = (direction + 1) % 4; //범위 밖에 나갔을 때 방향전환
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
        }

        return answer;
    }

    public int[][] solution3(int n) {
        int[][] array = new int[n][n];
        int num = 1;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 왼쪽에서 오른쪽으로
            for (int i = colStart; i <= colEnd; i++) {
                array[rowStart][i] = num++;
            }
            rowStart++;

            // 위에서 아래로
            for (int i = rowStart; i <= rowEnd; i++) {
                array[i][colEnd] = num++;
            }
            colEnd--;

            // 오른쪽에서 왼쪽으로
            for (int i = colEnd; i >= colStart; i--) {
                array[rowEnd][i] = num++;
            }
            rowEnd--;

            // 아래에서 위로
            for (int i = rowEnd; i >= rowStart; i--) {
                array[i][colStart] = num++;
            }
            colStart++;
        }
        return array;
    }
}
