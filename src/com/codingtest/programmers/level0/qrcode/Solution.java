package com.codingtest.programmers.level0.qrcode;

public class Solution {
    public String mySolution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                sb.append(code.charAt(i));
            }
        }
        return sb.toString();
    }

    public String solution(int q, int r, String code) {

        StringBuilder sb = new StringBuilder();

        for (int i = r; i < code.length(); i += q)
            sb.append(code.charAt(i));

        return sb.toString();
    }
}
