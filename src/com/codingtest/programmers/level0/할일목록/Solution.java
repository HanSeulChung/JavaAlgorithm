package com.codingtest.programmers.level0.할일목록;

import java.util.stream.IntStream;

public class Solution {
    public String[] mySolution(String[] todo_list, boolean[] finished) {
        String[] answer = IntStream.range(0, finished.length)
                .filter(i -> !finished[i])
                .mapToObj(i -> todo_list[i]).toArray(String[] :: new);
        return answer;
    }

    public String[] solution(String[] todo_list, boolean[] finished) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) {
                sb.append(todo_list[i]).append(",");
            }
        }

        return sb.toString().trim().split(",");
    }
}
