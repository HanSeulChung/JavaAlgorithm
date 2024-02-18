package com.codingtest.zerobaseschool.코딩테스트14주차;

public class P1 {
    public int solution(int N, int M) {

        if (N == M) {
            return N;
        }

        if (N % M == 0 || M % N == 0) {
            return Math.max(N, M);
        }

        int total = N * M;
        double value = M / (N * (1.0));

        int sum = 0;
        for (double i = 1; i < N; i++) {
            int tmp = (int)Math.floor(- value * i + M);
            sum += tmp;
        }

        return total -  2 * sum;
    }
}
