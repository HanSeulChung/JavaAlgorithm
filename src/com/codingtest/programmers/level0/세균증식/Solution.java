package com.codingtest.programmers.level0.세균증식;

public class Solution {
    public int mySolution(int n, int t) {

        while(t > 0) {
            n *= 2;
            t--;
        }
        return n;
    }
    public int solution(int n, int t) {
        int answer = 0;

        answer = n << t;

        return answer;
    }
}
