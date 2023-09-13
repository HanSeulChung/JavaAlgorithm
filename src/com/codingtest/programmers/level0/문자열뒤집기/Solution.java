package com.codingtest.programmers.level0.문자열뒤집기;

public class Solution {
    public String mySolution(String my_string, int s, int e) {
        String answer = "";
        char[] charArray = my_string.toCharArray();
        while(s < e) {
            char tmp = charArray[e];
            charArray[e] = charArray[s];
            charArray[s] = tmp;
            e--;
            s++;
        }
        return new String(charArray);
    }

    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string.substring(s, e + 1));
        answer.reverse();
        return my_string.substring(0, s) + answer + my_string.substring(e + 1);
    }
}
