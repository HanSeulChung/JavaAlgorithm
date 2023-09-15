package com.codingtest.programmers.level0.n번째원소까지;

import java.util.Arrays;

public class Solution {
    public int[] mySolution(int[] num_list, int n) {
        int[] answer = new int[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = num_list[i];
        }
        return answer;
    }

    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, 0, n);
    }
}
