package com.codingtest.programmers.level2.점찍기;

public class Solution {
    public static long solution(int k, int d) {
        long answer = 0;
        long dd = (long) d * d;
        for(int i = 0; i <= d; i += k)
        {
            long ii = (long) i * i;
            int top = (int) Math.sqrt(dd - ii);
            answer += (top / k) + 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(2,4));
        System.out.println(solution(1,5));
    }
}
