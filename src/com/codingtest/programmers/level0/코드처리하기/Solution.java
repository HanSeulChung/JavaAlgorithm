package com.codingtest.programmers.level0.코드처리하기;

public class Solution {
    public String mySolution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;

        int idx = 0;
        while (idx < code.length()) {

            if (code.charAt(idx) == '1') {
                mode = (mode == 0) ? 1 : 0;
            } else if (mode == 1 && idx % 2 != 0) {
                sb.append(code.charAt(idx));
            } else if (mode == 0 && idx % 2 == 0) {
                sb.append(code.charAt(idx));
            }
            idx++;
        }

        if (sb.length() == 0) {
            return "EMPTY";
        }

        return sb.toString();
    }

    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            if (current == '1') {
                mode = mode == 0 ? 1 : 0;
                continue;
            }

            if (i % 2 == mode) {
                answer.append(current);
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}
