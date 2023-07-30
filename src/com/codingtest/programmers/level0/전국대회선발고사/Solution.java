package com.codingtest.programmers.level0.전국대회선발고사;

import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        Map<Integer, Boolean> checkAttendance = new HashMap<>();

        for (int i = 0 ; i < rank.length; i++) {
            checkAttendance.put(rank[i], attendance[i]);
        }

        Map<Integer, Integer> checkIndex = new HashMap<>();
        for (int i = 0; i < attendance.length; i++) {
            checkIndex.put(rank[i], i);
        }

        int cnt = 4;
        for (Integer key : checkAttendance.keySet()){
            if(checkAttendance.get(key)) {
                answer += checkIndex.get(key) * (int)Math.pow(10, cnt);
                cnt -= 2;
            }
        }
        return answer;
    }
}