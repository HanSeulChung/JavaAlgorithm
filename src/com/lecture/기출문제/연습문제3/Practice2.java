package com.lecture.기출문제.연습문제3;

import java.util.Arrays;

public class Practice2 {
    public static String[] solution(int n, int[] memo1, int[] memo2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String decoding = Integer.toBinaryString(memo1[i] | memo2[i]);
            decoding = String.format("%" + n + "s",decoding);
            decoding = decoding.replaceAll("0", " ");
            decoding = decoding.replaceAll("1", "#");
            result[i] = decoding;
        }
        return result;
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

