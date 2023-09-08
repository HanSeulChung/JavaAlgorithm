package com.codingtest.programmers.level0.배열조각하기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] bestSolution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                end = start + query[i] - 1;
            } else {
                start += query[i];
            }
        }

        return Arrays.copyOfRange(arr, start, end + 2);
    }

    public int[] solution(int[] arr, int[] query) {
        List<Integer> listanswer = new ArrayList<>(
                Arrays.stream(arr).boxed().collect(Collectors.toList()));

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                listanswer = listanswer.subList(0, query[i] + 1);
            } else {
                listanswer = listanswer.subList(query[i], listanswer.size());
            }
        }
        return listanswer.stream().mapToInt(i -> i).toArray();
    }
}
