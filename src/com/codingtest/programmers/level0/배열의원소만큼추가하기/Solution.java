package com.codingtest.programmers.level0.배열의원소만큼추가하기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] mySolution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            for (int i = 0; i < num; i++) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
