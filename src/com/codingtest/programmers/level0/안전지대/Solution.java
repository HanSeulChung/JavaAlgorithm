package com.codingtest.programmers.level0.안전지대;

public class Solution {
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