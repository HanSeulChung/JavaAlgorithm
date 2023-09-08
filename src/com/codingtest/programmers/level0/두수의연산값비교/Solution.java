package com.codingtest.programmers.level0.두수의연산값비교;

public class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int ab = Integer.valueOf(String.valueOf(a) + String.valueOf(b));
        int ab2 = 2 * a * b;
        return Math.max(ab,ab2);
    }
}
