package com.codingtest.programmers.level0.OX퀴즈;

import java.util.Arrays;

public class Solution {
    public String[] mySolution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int idx = 0;
        for (String expression : quiz) {
            String[] exArr = expression.split(" ");
            int ex1 = Integer.parseInt(exArr[0]);
            int ex2 = Integer.parseInt(exArr[2]);
            String value = "X";
            if (exArr[1].equals("-")) {
                if (ex1 - ex2 == Integer.parseInt(exArr[4])) {
                    value = "O";
                }
            } else {
                if (ex1 + ex2 == Integer.parseInt(exArr[4])) {
                    value = "O";
                }
            }
            answer[idx++] = value;
        }
        return answer;
    }

    public String[] solution1(String[] quiz) {
        for (int i = 0; i < quiz.length; i++) {
            String[] text = quiz[i].split(" ");
            int result = Integer.parseInt(text[0]) + (Integer.parseInt(text[2]) * (text[1].equals("+") ? 1 : -1));
            quiz[i] = result == Integer.parseInt(text[4]) ? "O" : "X";
        }
        return quiz;
    }

    public String[] solution2(String[] quiz) {
        return Arrays.stream(quiz).map(s -> {
            String[] arr = s.trim().split(" ");
            return arr[1].equals("+") && Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) || Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) ? "O" : "X";
        }).toArray(String[]::new);
    }
}
