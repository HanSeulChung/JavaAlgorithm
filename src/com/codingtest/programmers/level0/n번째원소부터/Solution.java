package com.codingtest.programmers.level0.n번째원소부터;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int[] mySteamSolution(int[] num_list, int n) {
        return IntStream.range(n - 1, num_list.length).map(i -> num_list[i]).toArray();
    }

    public int[] solution1(int[] num_list, int n) {
        int[] a = Arrays.copyOfRange(num_list, n-1, num_list.length);
        return a;
    }

    public int[] solution2(int[] num_list, int n) {
        int[] answer = new int[num_list.length - (n-1)];

        for(int i=n-1; i<num_list.length; i++) {
            answer[i - (n-1)] = num_list[i];
        }

        return answer;
    }
}
