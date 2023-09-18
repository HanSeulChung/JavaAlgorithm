package com.codingtest.programmers.level0.무작위로k개의수뽑기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] mySolution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]) && idx < answer.length) {
                map.put(arr[i], 1);
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}
