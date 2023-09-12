package com.codingtest.programmers.level0.수열과구간쿼리4;

public class Solution {
    public void queryCheck(int start, int end, int k, int[] arr) {
        for (int i = start; i <= end; i++) {
            if (i % k == 0){
                arr[i]++;
            }
        }
    }

    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            queryCheck(query[0], query[1], query[2], arr);
        }
        return arr;
    }
}
