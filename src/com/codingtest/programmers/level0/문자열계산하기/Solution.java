package com.codingtest.programmers.level0.문자열계산하기;

import java.util.Arrays;

public class Solution {
    public int mySolution(String my_string) {

        String[] strArr = my_string.split(" ");
        int answer = Integer.parseInt(strArr[0]);
        for (int i = 1; i < strArr.length - 1; i++) {
            if (strArr[i].equals("+")) {
                answer += Integer.parseInt(strArr[i + 1]);
            } else if (strArr[i].equals("-")) {
                answer -= Integer.parseInt(strArr[i + 1]);
            }
        }
        return answer;
    }
    public int solution(String myString) {
        return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
    }
}
