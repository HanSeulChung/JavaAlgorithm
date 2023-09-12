package com.codingtest.programmers.level0.수열과구간쿼리2;

import java.util.stream.IntStream;
public class Solution {
    static int minValue;

    public int[] mySolution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        int idx = 0;
        for (int[] query : queries) {
            minValue = Integer.MAX_VALUE;
            for (int i = query[0]; i <= query[1]; i++) {
                if (query[2] >= arr[i]) {
                    continue;
                } else if (minValue > arr[i]) {
                    minValue = arr[i];
                }
            }
            if (minValue == Integer.MAX_VALUE) {
                answer[idx++] = -1;
            } else {
                answer[idx++] = minValue;
            }
        }
        return answer;
    }

    public int[] streamSolution(int[] arr, int[][] queries) {
        int[] answer = {};
        return IntStream.range(0, queries.length)
                .map(q -> IntStream.rangeClosed(queries[q][0], queries[q][1])
                        .map(i -> arr[i])
                        .filter(i -> i > queries[q][2])
                        .min().orElse(-1)
                ).toArray();
    }
}
