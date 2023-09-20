package com.codingtest.programmers.level0.전국대회선발고사;

import java.util.*;
class Solution {
    public int mySolution2(int[] rank, boolean[] attendance) {
        int answer = 0;
        int cnt = 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                map.put(rank[i], i);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int idx = 0;
        while (cnt >= 0) {
            answer += (int) Math.pow(100, cnt) * map.get(list.get(idx++));
            cnt--;
        }

        return answer;
    }
    public int mySolution1(int[] rank, boolean[] attendance) {
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