package com.codingtest.programmers.level0.배열의길이에따라다른연산하기;

public class Solution {
    public int[] mySolution(int[] arr, int n) {
        int[] answer = arr.clone();
        if (arr.length % 2 != 0) {
            for (int i = 0; i < answer.length; i += 2) {
                answer[i] += n;
            }
        } else {
            for (int i = 1; i < answer.length; i += 2) {
                answer[i] += n;
            }
        }
        return answer;
    }
    public int[] solution1(int[] arr, int n) {
        for (int idx = arr.length % 2 == 0 ? 1 : 0; idx < arr.length; idx += 2) {
            arr[idx] += n;
        }
        return arr;
    }
}
