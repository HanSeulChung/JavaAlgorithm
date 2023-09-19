package com.codingtest.programmers.level0.날짜비교하기;

import java.time.LocalDate;

public class Solution {

    public int mySolution(int[] date1, int[] date2) {

        if (date1[0] < date2[0]) {
            return 1;
        } else if (date1[0] > date2[0]) {
            return 0;
        }

        if (date1[1] < date2[1]) {
            return 1;

        } else if (date1[1] > date2[1]) {
            return 0;
        }

        if (date1[2] < date2[2]) {
            return 1;
        }

        return 0;
    }

    public int solution1(int[] date1, int[] date2) {
        int answer = 0;

        for(int i=0; i < date1.length; i++) {
            if(date1[i] < date2[i]) {
                answer = 1;
                break;
            }else if(date1[i] > date2[i]){
                answer = 0;
                break;
            }
        }

        return answer;
    }

    public int otherSolution(int[] date1, int[] date2) {

        LocalDate dateA = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate dateB = LocalDate.of(date2[0], date2[1], date2[2]);

        if (dateA.isBefore(dateB)) {
            return 1;
        } else {
            return 0;
        }
    }
}
