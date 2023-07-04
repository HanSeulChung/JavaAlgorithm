package com.codingtest.zerobaseshool.hintsfor3.배열2차원;
//  2167번
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void printMatrix(int[][] arr){
        for (int[] rows : arr){
            for (int cols : rows){
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = arr2[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
//        printMatrix(arr2);
//        printMatrix(prefixSum);
//        System.out.println();
        int K = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] answers = new int[K];
        for (int cnt = 0; cnt < K; cnt++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            answers[cnt] = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}
