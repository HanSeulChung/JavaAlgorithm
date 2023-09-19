package com.codingtest.programmers.level0.배열의원소삭제하기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
    public int[] mySolution(int[] arr, int[] delete_list) {
        Map<Integer, Integer> deleteMap =  new HashMap<>();

        for (int deleteN : delete_list) {
            deleteMap.put(deleteN, 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int arrN : arr) {
            if (!deleteMap.containsKey(arrN)) {
                list.add(arrN);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for(int n : arr) {
            list.add(n);
        }
        for(int n: delete_list) {
            list.remove((Integer)n);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public int[] streamSolution(int[] arr, int[] delete_list) {
        return IntStream.of(arr).filter(i -> !IntStream.of(delete_list).anyMatch(s -> s == i)).toArray();
    }
}
