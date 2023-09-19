package com.codingtest.programmers.level0.칠의개수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int mySolution(int[] array) {
        int answer = 0;

        for (int num : array) {
            while (num > 0) {
                if (num == 7 || num % 10 == 7) {
                    answer++;
                }
                num /= 10;
            }
        }
        return answer;
    }

    public int solution(int[] array) {
        return (int) Arrays.stream(
                        Arrays.stream(array)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining())
                                .split("")
                )
                .filter(s -> s.equals("7"))
                .count();
    }
}
