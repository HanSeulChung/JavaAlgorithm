package com.codingtest.programmers.level0.콜라츠수열만들기;

import java.util.*;
public class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        while (n > 1) {
            list.add(n);
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        list.add(1);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
