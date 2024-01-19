package com.codingtest.programmers.level1.MBTIforKaKao;

import java.util.*;

public class Solution {
    final int zero = 4;
    Map<Character, Integer> map;
    char[] charArray;
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        answer.append("RCJA");

        initSetting();

        for (int idx = 0; idx < choices.length; idx++) {
            int choice = choices[idx];

            if (choice < zero) {
                map.put(survey[idx].charAt(0), Math.abs(map.get(survey[idx].charAt(0)) + zero - choice));
            } else if (choice > zero) {
                map.put(survey[idx].charAt(1), map.get(survey[idx].charAt(1)) + choice - zero);
            }
        }
        if (map.get(charArray[0]) < map.get(charArray[1])) {
            answer.setCharAt(0, charArray[1]);
        }

        if (map.get(charArray[2]) < map.get(charArray[3])) {
            answer.setCharAt(1, charArray[3]);
        }

        if (map.get(charArray[4]) < map.get(charArray[5])) {
            answer.setCharAt(2, charArray[5]);
        }

        if (map.get(charArray[6]) < map.get(charArray[7])) {
            answer.setCharAt(3, charArray[7]);
        }
        return answer.toString();
    }

    private void initSetting() {
        map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        charArray = new char[8];
        int index = 0;
        charArray[index++] = 'R';
        charArray[index++] = 'T';
        charArray[index++] = 'C';
        charArray[index++] = 'F';
        charArray[index++] = 'J';
        charArray[index++] = 'M';
        charArray[index++] = 'A';
        charArray[index++] = 'N';
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice = {5, 3, 2, 7, 5};
        Solution s = new Solution();
        System.out.println(s.solution(survey, choice));
    }
}
