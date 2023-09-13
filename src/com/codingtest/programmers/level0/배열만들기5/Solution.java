package com.codingtest.programmers.level0.배열만들기5;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for (String str : intStrs) {
            int cur = Integer.parseInt(str.substring(s, s + l));
            if (k < cur) {
                list.add(cur);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
