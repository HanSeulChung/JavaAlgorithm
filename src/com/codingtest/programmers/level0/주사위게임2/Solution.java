package com.codingtest.programmers.level0.주사위게임2;

public class Solution {
    public int mySolution(int a, int b, int c) {
        if (a == b && b == c && a == c) {
            int sumA = a + b + c;
            int sumB = (int) (Math.pow(a, 2) +  Math.pow(b, 2) +  Math.pow(c, 2));
            int sumC = (int) (Math.pow(a, 3) +  Math.pow(b, 3) +  Math.pow(c, 3));
            return sumA * sumB * sumC;
        } else if (a != b && b != c && a != c) {
            int sumA = a + b + c;
            return sumA;
        } else {
            int sumA = a + b + c;
            int sumB = (int) (Math.pow(a, 2) +  Math.pow(b, 2) +  Math.pow(c, 2));
            return sumA * sumB;
        }
    }
    public int solution(int a, int b, int c) {
        int answer = 1;

        int count = 1;
        if(a == b || a == c || b == c) {
            count++;
        }

        if(a == b && b == c) {
            count++;
        }

        for(int i = 1; i <= count; i++) {
            answer *= (pow(a, i) + pow(b, i) + pow(c, i));
        }

        return answer;
    }

    private int pow(int a, int b) {
        if(b == 0) return 1;
        return a * pow(a, b - 1) ;
    }
}
