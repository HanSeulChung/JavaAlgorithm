package com.codingtest.programmers.level0.수열과구간쿼리3;

public class Solution {
    public void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            swap(query[0], query[1], arr);
        }
        return arr;
    }
}
