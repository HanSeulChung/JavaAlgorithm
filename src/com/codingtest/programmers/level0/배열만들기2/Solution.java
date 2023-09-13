package com.codingtest.programmers.level0.배열만들기2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] mySolution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            String str = "" + i;
            cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 48 || str.charAt(j) == 53) {
                    cnt++;
                }
            }
            if (cnt == str.length()) {
                list.add(Integer.parseInt(str));
            }
        }
        if (list.size() == 0) {
            return new int[]{-1};
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public int[] solution(int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < 64; i++) {
            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
            if (l <= num && num <= r)
                list.add(num);
        }

        return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
    }
}
