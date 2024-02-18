package com.codingtest.zerobaseschool.hintsfor3.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1; // 첫 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int next = board[i][j];
                if(next == 0){
                    break;
                }
                if(i+next<N){
                    dp[i+next][j] +=dp[i][j];
                }
                if(j+next <N){
                    dp[i][j+next] +=dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);

    }

}
