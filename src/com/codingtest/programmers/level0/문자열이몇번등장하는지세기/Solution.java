package com.codingtest.programmers.level0.문자열이몇번등장하는지세기;

import java.util.stream.Stream;

public class Solution {
    public int mySolution(String myString, String pat) {
        int answer = 0;
        int L = pat.length();
        for (int i = 0; i <= myString.length() - L; i++) {
            if (pat.equals(myString.substring(i, L + i))) {
                answer++;
            }
        }
        return answer;
    }

    public int solution1(String myString, String pat) {
        int cnt = 0;
        for(int i=0; i<myString.length(); i++) {
            if(myString.substring(i).startsWith(pat)){
                cnt++;
            }
        }
        return cnt;
    }

    public int solution2(String myString, String pat) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(myString.length() - pat.length() + 1)
                .filter(i -> myString.substring(i, i + pat.length()).equals(pat))
                .count();
    }
}
