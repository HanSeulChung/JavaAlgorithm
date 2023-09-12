package com.codingtest.programmers.level0.간단한논리연산;

public class Solution {
    public boolean mySolution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean firstX = true;
        boolean secondX = true;
        if (!x1 && !x2) {
            firstX = false;
        }

        if (!x3 && !x4) {
            secondX = false;
        }

        if (!firstX || !secondX) {
            return false;
        }
        return true;
    }

    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = (x1||x2)&&(x3||x4);
        return answer;
    }
}
