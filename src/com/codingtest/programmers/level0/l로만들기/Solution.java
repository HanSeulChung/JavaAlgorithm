package com.codingtest.programmers.level0.l로만들기;

import java.util.stream.Collectors;

public class Solution {

    public String mySolution(String myString) {
        String answer = "";
        char[] charArr = myString.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] < 'l') {
                charArr[i] = 'l';
            }
        }
        return new String(charArr);
    }

    public String solution1(String myString) {
        return myString.replaceAll("[^l-z]", "l");
    }

    public String solution2(String myString) {
        return myString.chars()
                .mapToObj(i -> Character.toString((char) Integer.max(i, 'l')))
                .collect(Collectors.joining());
    }
}
