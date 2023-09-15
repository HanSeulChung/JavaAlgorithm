package com.codingtest.programmers.level0.n보다커질때까지더하기;

import java.util.Arrays;

public class Solution {
    public int mySolution(int[] numbers, int n) {
        int answer = 0;
        for (int num : numbers) {
            if (answer > n) {
                return answer;
            }
            answer += num;
        }
        return answer;
    }

    public int streamSolution(int[] numbers, int n) {
        return Arrays.stream(numbers).reduce(0, (acc, i) -> n >= acc ? acc + i : acc);
    }

    public int solution(int[] numbers, int n) {
        int answer = 0;

        for(int i = 0; answer <= n; i++) {
            answer += numbers[i];
        }

        return answer;
    }
}
