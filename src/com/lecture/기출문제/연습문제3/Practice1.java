package com.lecture.기출문제.연습문제3;


public class Practice1 {
    public static int solution(String str) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            str = str.replaceAll(words[i], String.valueOf(i));
        }
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("onetwothreefour"));
        System.out.println(solution("twozerothreezero"));
        System.out.println(solution("three21zero"));
    }
}
