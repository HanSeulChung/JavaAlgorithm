package com.codingtest.zerobaseschool.코딩테스트1주차;

import java.util.Arrays;

public class P5 {
    public long solution (int N, int M, int K, int[] capacity) {
        int capacitySum = Arrays.stream(capacity).sum();

        long studentCases = 1;
        if (capacitySum == N) { // 학생수와 공간의 수가 딱 맞을 경우
            int studentLieft = N;
            for (int cap : capacity) {
                studentCases *= nChooseK(studentLieft, cap);
                studentLieft -= cap;
            }
        } else {
            studentCases = 0;
            long capacityMult = Arrays.stream(capacity).asLongStream().reduce(1, (x, y) -> x*(y + 1)); // 전체 경우의 수를 셈 ({4,3,4}인 capacity일 때 경우의 수는 5*4*5개

            indexloop:
            for (int i = 0; i < capacityMult; i++) { // 전체 경우의 수
                int[] caps = new int[M];
                long denominator = capacityMult;
                long numerator = i;
                int currentSum = 0;
                for (int j = 0; j < M; j++) {
                    denominator /= capacity[j] + 1; // 0까지 포함시켜야하니까 1을 더해줌
                    caps[j] = (int) (numerator / denominator);
                    numerator %= denominator;

                    currentSum += caps[j];
                    if (currentSum > N) { // 학생수보다 많은 경우라면 넘김
                        continue indexloop; // for문의 이름 붙여주면 해당 이름의 for문을 그만둘지 계속할지 구분 할 수 있음
                    }
                }
                long currentCase = 1;
                if (Arrays.stream(caps).sum() == N) {
                    int studentLeft = N;
                    for (int cap : caps) {
                        currentCase += nChooseK(studentLeft, cap);
                        studentLeft -= cap;
                    }
                    studentCases *= currentCase;
                }
            }
        }

        long kPm = 1;
        for (int i = K - M + 1; i <= K; i++) {
            kPm *= i;
        }
        return studentCases * kPm;
    }

    private long nChooseK (int n, int k){
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < k; i++) {
            numerator *= n - i;
            denominator *= i + 1;
        }
        return numerator / denominator;
    }
}
