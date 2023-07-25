package com.codingtest.backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    static int sum = 0;
    static int firstTeamSum = 0;
    static int[] rowSum;
    static int[] colSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        S = new int[N][N];
        rowSum = new int[N];
        colSum = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rowSum[i] = 0;
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
                sum += S[i][j];
                rowSum[i] += S[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            colSum[i] = 0;
            for (int j = 0; j < N; j++) {
                colSum[i] += S[j][i];
            }

        }
        visited[0] = true;
        sum -= (rowSum[0] + colSum[0]);
        combination(0,1);
        System.out.println(minDiff);
    }

    public static void combination(int idx, int cnt) {
        if (cnt == N / 2) {
            int secondTeamSum = sum;
            minDiff = (int)Math.min(minDiff, (int)Math.abs(firstTeamSum - secondTeamSum));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                int tmp = sum;
                visited[i] = true;
                firstTeamSum += (S[i][idx] + S[idx][i]);
                sum -= (rowSum[i] + colSum[i]);
                sum += (S[i][idx] + S[idx][i]);
                combination(i, cnt + 1);
                firstTeamSum -= (S[i][idx] + S[idx][i]);
                sum = tmp;
                visited[i] = false;
            }
        }
    }
}
