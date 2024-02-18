package com.codingtest.zerobaseschool.코딩테스트6주차;

import java.util.Arrays;
public class P5 {
    public int[] bestsolution(int[] scores) {
        int[] answer = new int[scores.length];
        Arrays.fill(answer, 1);

        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] < scores[i + 1]) {
                answer[i + 1] = answer[i] + 1;
            }
        }

        for (int i = scores.length - 1; i > 0; i--){
            if (scores[i - 1] > scores[i]) {
                answer[i - 1] = Math.max(answer[i - 1], answer[i] + 1);
            }
        }
        return answer;
    }
    public int[] mysolution(int[] scores) {
        int n = scores.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) {
                answer[i] = answer[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1] && answer[i] <= answer[i + 1]) {
                answer[i] = answer[i + 1] + 1;
            }
        }

        return answer;
    }
    public int[] solution(int[] scores) {
        int[] chocos = new int[scores.length];
        Arrays.fill(chocos, 1);

        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i + 1] > scores[i]) {
                chocos[i + 1] = chocos[i] + 1;
            }
        }

        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i + 1] < scores[i]) {
                chocos[i] = Math.max(chocos[i + 1] + 1, chocos[i]);
            }
        }
        return chocos;
    }
}
