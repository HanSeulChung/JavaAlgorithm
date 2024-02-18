package com.codingtest.zerobaseschool.코딩테스트5주차;

import java.util.stream.IntStream;

public class P5 {
    public int soluiton(int N, int M, int[] fry, int[] clean) {
        int left = 1;
        int right = M * IntStream.range(0, fry.length).map(x -> fry[x] +clean[x]).max().getAsInt();

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int val = 0;
            for (int i = 0; i < fry.length; i++) {
                val += (mid + clean[i]) / (fry[i] + clean[i]);
            }

            if (val >= M) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
