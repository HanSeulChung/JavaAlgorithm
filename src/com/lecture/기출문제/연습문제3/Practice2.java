package com.lecture.기출문제.연습문제3;

import java.util.Arrays;

public class Practice2 {
    public static String[] solution(int n, int[] memo1, int[] memo2) {

        return null;
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int [] memo1 = {3, 4, 7};
        int [] memo2 = {4, 1, 3};
        System.out.println(Arrays.toString(solution(n, memo1, memo2)));

        n = 5;
        memo1 = new int[]{15, 21, 17, 18, 11};
        memo2 = new int[]{30, 1, 21, 19, 28};
        System.out.println(Arrays.toString(solution(n, memo1, memo2)));
    }
}

