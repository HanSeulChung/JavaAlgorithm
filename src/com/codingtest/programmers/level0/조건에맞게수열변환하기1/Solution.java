package com.codingtest.programmers.level0.조건에맞게수열변환하기1;

public class Solution {
    public int[] mySolution(int[] arr) {
        int[] answer =arr;

        for (int i = 0; i < answer.length; i++) {
            int num = answer[i];
            if (num >= 50 && num % 2 == 0) {
                answer[i] /= 2;
            } else if (num < 50 && num % 2 == 1) {
                answer[i] *= 2;
            }
        }
        return answer;
    }
}
