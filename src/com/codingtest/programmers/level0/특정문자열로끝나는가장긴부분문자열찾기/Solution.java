package com.codingtest.programmers.level0.특정문자열로끝나는가장긴부분문자열찾기;

public class Solution {
    public String mySolution(String myString, String pat) {
        String answer = "";
        int L = pat.length();
        int idx = -1;
        for (int i = 0; i < myString.length() - L + 1; i++) {
            if (myString.substring(i, i + L).contains(pat)) {
                idx = i;
            }
        }

        if (idx != -1) {
            return myString.substring(0, idx + L);
        }
        return answer;
    }

    public String solution1(String myString, String pat) {
        String answer = "";

        int idx = myString.lastIndexOf(pat);

        answer = myString.substring(0, idx) + pat;

        return answer;
    }

    public String solution2(String myString, String pat) {
        return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }
}
