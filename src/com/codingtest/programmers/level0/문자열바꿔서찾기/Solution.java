package com.codingtest.programmers.level0.문자열바꿔서찾기;

public class Solution {
    public int mySolution(String myString, String pat) {
        int answer = 0;

        pat = pat.replace("B", "C");
        pat = pat.replace("A", "B");
        pat = pat.replace("C", "A");

        if (myString.contains(pat)) {
            return 1;
        }

        return answer;
    }

    public int solution(String myString, String pat) {
        myString = myString.replace("A", "a").replace("B", "A").replace("a", "B");
        return myString.contains(pat) ? 1 : 0;
    }
}
