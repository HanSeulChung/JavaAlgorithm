package com.codingtest.programmers.level1.d2016;

import java.time.LocalDate;

public class Solution {
    public static String solution(int a, int b) {
        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
        int weeknumber = date.getDayOfWeek().getValue();

        switch(weeknumber){
            case 1:
                answer = "MON";
                break;
            case 2:
                answer = "TUE";
                break;
            case 3:
                answer = "WED";
                break;
            case 4:
                answer = "THU";
                break;
            case 5:
                answer = "FRI";
                break;
            case 6:
                answer = "SAT";
                break;
            case 7:
                answer = "SUN";
                break;
        }

        return answer;
    }
    public static void main(String[] args) {

        System.out.println(solution(5,24));
    }
}
