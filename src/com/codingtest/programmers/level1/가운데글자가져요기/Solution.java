package com.codingtest.programmers.level1.가운데글자가져요기;

public class Solution {
    public String solution(String s) {
        return s.substring((s.length() - 1)/2, s.length()/2 + 1); // if/ else 안나눠도된다..

//        if (s.length() % 2 != 0) {
//            return s.substring(s.length() / 2, s.length() / 2 + 1 );
//        } else {
//            return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
//        }
    }
}
