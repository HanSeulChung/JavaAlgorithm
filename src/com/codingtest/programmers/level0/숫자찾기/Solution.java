package com.codingtest.programmers.level0.숫자찾기;

import java.util.Arrays;

public class Solution {
    public int mySolution(int num, int k) {

        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) - '0' == k) {
                return i + 1;
            }
        }
        return -1;
    }
    public int solution(String myString) {
        return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
    }
}
