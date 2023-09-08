package com.codingtest.programmers.level0.문자열곱하기;

public class Solution {
    public String solution(String my_string, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(my_string);
        }
        return sb.toString();
    }

    public String solution1(String my_string, int k) {
        return my_string.repeat(k);
    }
}
