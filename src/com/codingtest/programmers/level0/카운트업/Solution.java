package com.codingtest.programmers.level0.카운트업;

import java.util.stream.IntStream;

public class Solution {
    public int[] mySolution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];
        int idx = 0;
        for (int i = start_num; i <= end_num; i++) {
            answer[idx++] = i;
        }
        return answer;
    }

    public int[] streamSolution(int start, int end) {
        return IntStream.rangeClosed(start, end).toArray();
    }
}
