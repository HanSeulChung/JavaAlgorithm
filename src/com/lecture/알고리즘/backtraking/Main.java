package com.lecture.알고리즘.backtraking;

// 알고리즘 - 백트래킹

public class Main {
    static int n = 4;
    static int[] board = new int[n];
    static int cnt;
    public static int nQueen(int row) {
        if(row==n){
            cnt++; // 다 놓았을 때 1번 체크해야하니까 마지막에만 ..
            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }
        for (int i = 0; i < n; i++) {
            board[row] = i; // 재귀적으로 들어올 것임 어느 방향에 놓을지에 따라 그것이 유망한지 아닌지 확인할 수 있으니 for문 이용

            if(isPromising(row)){
                nQueen(row+1);
            }
        }

        return cnt;
    }

    public static boolean isPromising(int row){
        for (int i = 0; i < row; i++) {
            if(board[row] == board[i] || row - i == Math.abs(board[i]-board[row])){ //행마다 입력받고 확인할 거니까 행은 check 안해도 되고 같은 열에 있는지, 대각선에 있는지만 check하면됨
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2
    }
}