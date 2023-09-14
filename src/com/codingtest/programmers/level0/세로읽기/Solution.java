package com.codingtest.programmers.level0.세로읽기;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String mySolution(String my_string, int m, int c) {
        int N = my_string.length() / m;
        int M = m;

        char[][] board = new char[N][M];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = my_string.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(board[i][c - 1]);
        }
        return sb.toString();
    }

    public String solution(String my_string, int m, int c) {
        String answer = "";

        for (int i = c - 1; i < my_string.length(); i += m) {
            answer += my_string.charAt(i);
        }
        return answer;
    }

    public String streamSolution(String myString, int m, int c) {
        return IntStream.range(0, myString.length())
                .filter(i -> i % m == c - 1)
                .mapToObj(i -> String.valueOf(myString.charAt(i)))
                .collect(Collectors.joining());
    }
}
