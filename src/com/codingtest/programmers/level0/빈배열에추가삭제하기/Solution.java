package com.codingtest.programmers.level0.빈배열에추가삭제하기;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public int[] mySolution(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                int cnt = arr[i] * 2;
                while (cnt > 0) {
                    list.add(arr[i]);
                    cnt--;
                }
            } else {
                int cnt = arr[i];
                while (cnt > 0) {
                    list.remove(list.size() - 1);
                    cnt--;
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public int[] solution1(int[] arr, boolean[] flag) {
        String answer = "";

//        for(int idx=0; idx<arr.length; idx++) {
//            if(flag[idx]) {
//                answer += String.valueOf(arr[idx]).repeat(arr[idx]*2);
//            }
//            else {
//                answer = answer.substring(0, answer.length() - arr[idx]);
//            }
//        }

        return Stream.of(answer.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
