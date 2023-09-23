package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.util.LinkedList;
import java.util.Queue;

public class P5 {
    public int soluiont(int N, int M, int[][] maze) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        int[] di = {0 , 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        int[][] visited = new int[N][M];
        while(!q.isEmpty()) {
            int[] ints = q.poll();
            int i = ints[0];
            int j = ints[0];

            if (i == N - 1 && j == M - 1) {
                return visited[i][j];
            }

            for (int k = 0; i < dj.length; k++) {
                int newI = i + di[k];
                int newJ = j + dj[k];

                if (newI < 0 || newI >= N || newJ < 0 || newJ >= M) {
                    continue;
                }

                if (maze[newI][newJ] == 0 && visited[newI][newJ] == 0) {
                    q.offer(new int[] {newI, newJ});
                    visited[newI][newJ] = visited[i][j] + 1;
                }
            }
        }
        return -1;
    }
}
