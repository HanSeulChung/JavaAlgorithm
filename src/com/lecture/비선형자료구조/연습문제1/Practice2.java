package com.lecture.비선형자료구조.연습문제1;

public class Practice2 {
    public static void solution(char[][] board) {
        if(board == null || board.length < 3 || board[0].length < 3){
            return;
        }

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if(board[i][0] == 'O'){ // 좌측 외곽 탐색
                dfs(board, i, 0);
            }

            if(board[i][col-1] == 'O'){ // 우측 외곽 탐색
                dfs(board, i, col-1);
            }
        }
        for (int i = 0; i < col; i++) { // 위쪽 외곽 탐색
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[row-1][i] == 'O'){ // 아래쪽 외곽 탐색
                dfs(board, row-1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                } else if( board[i][j] =='*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y){
        if(x<0 || y<0 || x>board.length -1 || y>board[0].length -1){
            return ;
        }
        if(board[x][y] != 'O'){
            return ;
        }

        board[x][y] = '*';
        dfs(board,x+1, y);
        dfs(board, x-1, y);
        dfs(board, x, y +1 );
        dfs(board, x, y -1);
    }
    public static void main(String[] args) {
        // Test code
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
