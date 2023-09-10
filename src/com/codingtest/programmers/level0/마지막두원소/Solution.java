package com.codingtest.programmers.level0.마지막두원소;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] mySolution(int[] num_list) {
        List<Integer> list = new ArrayList<>(Arrays.stream(num_list).boxed().collect(Collectors.toList()));

        int endElement = num_list[num_list.length - 1];
        int beforeElement = num_list[num_list.length - 2];
        if (endElement > beforeElement) {
            list.add(endElement - beforeElement);
        } else {
            list.add(endElement * 2);
        } // 다들 이 부분을 삼항으로 한줄로 표현했다.

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution(int[] num_list) {
       int[] answer = new int[num_list.length + 1];

        int endElement = num_list[num_list.length - 1];
        int beforeElement = num_list[num_list.length - 2];
        if (endElement > beforeElement) {
            answer[num_list.length] = endElement - beforeElement;
        } else {
            answer[num_list.length] = endElement * 2;
        }
        return answer;
    }
}
