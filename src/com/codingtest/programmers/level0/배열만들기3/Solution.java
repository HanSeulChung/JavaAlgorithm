package com.codingtest.programmers.level0.배열만들기3;

public class Solution {
    public int[] mySolution(int[] arr, int[][] intervals) {
        int[] answer = new int[intervals[0][1] - intervals[0][0]
                + intervals[1][1] - intervals[1][0] + 2];
        int idx= 0;
        for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            answer[idx++] = arr[i];
        }

        for (int i = intervals[1][0]; i <= intervals[1][1]; i++) {
            answer[idx++] = arr[i];
        }
        return answer;
    }
}
