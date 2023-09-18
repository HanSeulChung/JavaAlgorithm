package com.codingtest.programmers.level0.연속된수의합;

public class Solution {
    public int[] mySolution(int num, int total) {
        int[] answer = new int[num];
        int mid = -1;
        int midValue = total / num;
        if (num % 2 != 0) {
            mid = num / 2;
            answer[mid] = midValue;
        } else {
            mid = num / 2 - 1;
            answer[mid] = midValue;
        }

        int p1 = mid - 1;
        int p2 = mid + 1;
        int curValue1 = midValue;
        int curValue2 = midValue;

        while (p1 != -1 && p2 != answer.length) {
            answer[p1--] = --curValue1;
            answer[p2++] = ++curValue2;
        }

        if (answer[answer.length - 1] == 0 && num != 1) {
            answer[answer.length - 1] = ++curValue2;
        }

        return answer;
    }

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int check = num * (num + 1) / 2;
        int start = (total - check) / num + 1;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start + i;
        }
        return answer;
    }
}
