package com.codingtest.programmers.level0.순서바꾸기;

import java.util.stream.IntStream;

public class Solution {
    public int[] mySolution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int idx = 0;
        for (int i = n; i < num_list.length; i++) {
            answer[idx++] = num_list[i];
        }
        for (int i = 0; i < n; i++) {
            answer[idx++] = num_list[i];
        }
        return answer;
    }

    public int[] solution(int[] num_list, int n) {
        return IntStream.range(0, num_list.length).map(i -> num_list[(i + n) % num_list.length]).toArray();
    }
}
