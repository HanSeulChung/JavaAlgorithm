package com.codingtest.programmers.level0.안전지대;

public class Solution {

    public void dfs1(int x, int y, int[][] board) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    answer++;
                }
            }
        }
    }

    public int solution1(int[][] board) {
        answer = 0;
        n = board.length;
        visited = new boolean[n][n];

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (!visited[i][j]) {
                        answer++;
                    }
                    dfs(i, j, board);
                }
            }
        }

        return n * n - answer;
    }
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {1, 0 , -1, 1, -1, 1, 0, -1};
    static boolean[][] visited;
    static int answer;
    static int n;

    public void dfs(int x, int y, int[][] board) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public int mySolution(int[][] board) {
        answer = 0;
        n = board.length;
        visited = new boolean[n][n];

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    dfs(i, j, board);
                }
            }
        }

        for (int j = 0 ; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (!visited[j][i]) {
                    answer++;
                }
            }
        }

        return answer;
    }
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        int[][] newBoard = new int[N][N];
        for(int i =0; i< N; i++){
            for(int j=0; j< N; j++){
                if(board[i][j]==1){
                    checkExplosion(i, j, newBoard);
                }
            }
        }

        for(int[] row: newBoard){
            for(int col:row){
                if(col == 1){
                    answer++;
                }
            }
        }
        return N*N - answer;
    }

    public static void checkExplosion(int x, int y, int[][] newBorad){
        int explosionX;
        int explosionY;

        int[] dx = {0, -1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, 0, -1};

        for(int i =0; i<9; i++){
            explosionX = x + dx[i];
            explosionY = y + dy[i];
            if(explosionX < newBorad.length && explosionY < newBorad.length
                    && explosionX >= 0 && explosionY >= 0){
                newBorad[explosionX][explosionY] = 1;
            }
        }
    }
}