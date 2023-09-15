package com.codingtest.programmers.level0.two의영역;

import java.util.stream.IntStream;

public class Solution {
    public int[] mySolution(int[] arr) {
        int[] answer = {};
        int initIdx = -1;
        int finalIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2 && initIdx == -1) {
                initIdx = i;
            } else if (arr[i] == 2 && initIdx != -1) {
                finalIdx = i;
            }
        }

        if (initIdx == -1 && finalIdx == -1) {
            return new int[]{-1};
        } else if (initIdx != -1 && finalIdx == -1) {
            return new int[]{2};
        }

        answer = new int[finalIdx - initIdx + 1];
        int idx = 0;
        for (int i = initIdx; i <= finalIdx; i++){
            answer[idx++] = arr[i];
        }
        return answer;
    }

    public int[] streamSolution(int[] arr) {
        int[] idx = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
        if (idx.length == 0) return new int[]{-1};
        return IntStream.rangeClosed(idx[0], idx[idx.length - 1]).map(i -> arr[i]).toArray();
    }
}
