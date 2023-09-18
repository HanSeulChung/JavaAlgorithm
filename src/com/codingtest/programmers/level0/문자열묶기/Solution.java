package com.codingtest.programmers.level0.문자열묶기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int mySolution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String str : strArr) {
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        if (maxEntry != null){
            return maxEntry.getValue();
        }

        return 0;
    }
    public int solution1(String[] strArr) {
        int answer = 0;

        int[] lengArr = new int[31];

        for(int i=0; i<strArr.length; i++) {
            lengArr[strArr[i].length()]++;
        }

        for(int i=0; i<=30; i++) {
            answer = Math.max(answer, lengArr[i]);
        }
//        for (int x : lengArr) {
//            answer=Math.max(answer,x);
//        }
        return answer;
    }

    public int solution2(String[] strArr) {
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        for (String str : strArr) {
            int len = str.length();
            if (map.containsKey(len)) {
                map.get(len).add(str);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(len, temp);
            }
        }

        int answer = 0;
        for (int len : map.keySet())
            answer = Math.max(answer, map.get(len).size());
        return answer;
    }
}
