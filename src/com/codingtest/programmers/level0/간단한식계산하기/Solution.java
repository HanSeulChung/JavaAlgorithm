package com.codingtest.programmers.level0.간단한식계산하기;

public class Solution {
    public int mySolution(String binomial) {
        int answer = 0;
        String[] strArr = binomial.split(" ");

        switch (strArr[1]) {
            case "+" :
                return Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
            case "-" :
                return Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]);
            case "*" :
                return Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2]);
        }
        return answer;
    }
}
