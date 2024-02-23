package com.codingtest.backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][N];
    int[][] preSum = new int[N + 1][N + 1];
    for (int row = 0; row < N; row++) {
      st = new StringTokenizer(br.readLine());
      for (int col = 0; col < N; col++) {
        map[row][col] = Integer.parseInt(st.nextToken());
      }
    }

    for (int row = 1; row <= N; row++) {
      for (int col = 1; col <= N; col++) {
        preSum[row][col] = preSum[row - 1][col] + preSum[row][col - 1] - preSum[row - 1][col - 1] + map[row - 1][col - 1];
      }
    }

    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int row1 = Integer.parseInt(st.nextToken());
      int col1 = Integer.parseInt(st.nextToken());
      int row2 = Integer.parseInt(st.nextToken());
      int col2 = Integer.parseInt(st.nextToken());
      System.out.println(preSum[row2][col2] - preSum[row1 - 1][col2] - preSum[row2][col1 - 1] + preSum[row1 - 1][col1 - 1] );
    }
    br.close();
  }
}
