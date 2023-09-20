package com.codingtest.programmers.level0.자릿수더하기;

public class Solution {
    public int mySolution(int n) {
        int answer = 0;
        String strN = String.valueOf(n);
        for (char c : strN.toCharArray()) {
            answer += c - '0';
        }
        return answer;
    }

    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
