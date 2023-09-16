package com.codingtest.programmers.level0.원하는문자열찾기;

public class Solution {
    public int mySolution(String myString, String pat) {
        int answer = 0;
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();

        if (myString.contains(pat)) {
            return 1;
        }
        return answer;
    }
    public int solution(String myString, String pat) {
        int answer = 0;
        String str = myString.toLowerCase();
        String str2 = pat.toLowerCase();

        if (str.indexOf(str2) != -1) {
            return 1;
        }
        return 0;
    }
}
