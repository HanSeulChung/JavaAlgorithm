package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500{

    static int N;
    static int M;
    static int[][] board;
    static int maxValue = Integer.MIN_VALUE;
    static int[] maxPoint = new int[2];
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (maxValue < board[i][j]) {
                    maxValue = board[i][j];
                    maxPoint[0] = i;
                    maxPoint[1] = j;
                }
            }
        }

        System.out.println(maxSum);
    }

    public static void tetromino() {

    }


}

