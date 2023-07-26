package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500{

    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    static int maxSum = 0;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        int initsum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                initsum = board[i][j];
                visited[i][j] = true;
                dfs(i, j, initsum, 1);
                visited[i][j] = false;
            }
        }
        System.out.println(maxSum);
    }

    public static void dfs(int row, int col, int sum, int cnt) {
        if (cnt == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int rNext = row + dr[i];
            int cNext = col + dc[i];

            if (rNext < 0 || rNext >= N || cNext < 0 || cNext >= M) {
                continue;
            }

            if (!visited[rNext][cNext]) {
                int tmpSum = sum + board[rNext][cNext];
                if (cnt == 2) { // ㅗ, ㅓ, ㅏ, ㅜ 와 같은 모양은 연속적인 완전탐색이 아니라 두번째 칸에서 다시 시작해줘야함.
                    visited[rNext][cNext] = true;
                    dfs(row, col, tmpSum, cnt + 1);
                    visited[rNext][cNext] = false;
                }

                visited[rNext][cNext] = true;
                dfs(rNext, cNext, tmpSum, cnt + 1);
                visited[rNext][cNext] = false;
            }
        }
    }
}

