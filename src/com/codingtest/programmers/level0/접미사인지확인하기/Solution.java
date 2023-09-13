package com.codingtest.programmers.level0.접미사인지확인하기;

public class Solution {
    public int mySolution(String my_string, String is_suffix) {
        if (my_string.contains(is_suffix)
                && my_string.charAt(my_string.length() - 1) == is_suffix.charAt(is_suffix.length() - 1)) {
            return 1;
        } else {
            return 0;
        }
    }

    public int solution(String my_string, String is_suffix) {
        if(my_string.endsWith(is_suffix)) {
            return 1;
        } else {
            return 0;
        }
    }
}
