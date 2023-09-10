package com.codingtest.programmers.level0.원소들의곱과합;

import java.util.Arrays;

public class Solution {
    public int mySolution(int[] num_list) {
        int answer = 0;
        int multiply = 1;
        int sum = 0;
        for (int num : num_list) {
            multiply *= num;
            sum += num;
        }

        return multiply < (int)Math.pow(sum, 2) ? 1 : 0;
    }

    public int streamSolution(int[] numList) {
        return (Arrays.stream(numList).reduce((acc, i) -> acc * i).getAsInt() < Math.pow(Arrays.stream(numList).sum(), 2)) ? 1 : 0;
    }
}
