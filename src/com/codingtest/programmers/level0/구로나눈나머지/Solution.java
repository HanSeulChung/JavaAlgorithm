package com.codingtest.programmers.level0.구로나눈나머지;

public class Solution {
    public int mySolution(String number) {
        int answer = 0;
        for (int i = 0; i < number.length(); i++) {
            answer += number.charAt(i) - '0';
        }
        return answer % 9;
    }
    public int streamSolution(String number) {
        return number.chars().map(c -> (c - '0') % 9).sum() % 9;
    }
}
