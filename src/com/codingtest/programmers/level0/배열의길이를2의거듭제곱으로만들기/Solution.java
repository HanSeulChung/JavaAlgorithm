package com.codingtest.programmers.level0.배열의길이를2의거듭제곱으로만들기;

import java.util.*;

public class Solution {
    public int[] mySolution(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1);
        map.put(4, 2);
        map.put(8, 3);
        map.put(16, 4);
        map.put(32, 5);
        map.put(64, 6);
        map.put(128, 7);
        map.put(256, 8);
        map.put(512, 9);
        map.put(1024, 10);

        if (map.containsKey(arr.length)) {
            return arr;
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int maxValue = -1;
        for (int i = 0; i < list.size(); i++) {
            if (arr.length < list.get(i)) {
                maxValue = list.get(i);
                break;
            }
        }

        int[] answer = new int[maxValue];
        Arrays.fill(answer, 0);

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }

    public int[] solution(int[] arr) {
        int length = 1;

        while (length < arr.length) {
            length *= 2;
        }

        return Arrays.copyOf(arr, length);
    }
}
