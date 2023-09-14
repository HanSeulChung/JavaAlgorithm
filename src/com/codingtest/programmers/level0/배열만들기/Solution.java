package com.codingtest.programmers.level0.배열만들기;

import java.util.stream.IntStream;

public class Solution {
    public int[] mySolution(int n, int k) {
        int[] answer = new int[n / k];

        int idx = answer.length - 1;
        for (int i = n / k; i > 0; i--) {
            answer[idx--] = i * k;
        }
        return answer;
    }

    public int[] solution(int n, int k) {
        int count = n / k;


        int[] answer = new int[count];

        for (int i = 1; i <= count; i++) {
            answer[i - 1] = k * i;
        }

        return answer;
    }

    public int[] streamSolution(int n, int k) {
        return IntStream.rangeClosed(1, n).filter(i -> i % k == 0).toArray();
    }
}
