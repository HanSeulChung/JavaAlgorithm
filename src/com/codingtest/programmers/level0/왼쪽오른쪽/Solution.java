package com.codingtest.programmers.level0.왼쪽오른쪽;

import java.util.Arrays;

/**
 * 3점
 */
public class Solution {
    public String[] mySolution(String[] str_list) {
        String[] answer = {};
        int leftIdx = -1;
        int rightIdx = -1;

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                leftIdx = i;
                break;
            } else if (str_list[i].equals("r")) {
                rightIdx = i;
                break;
            }
        }

        if (leftIdx != -1) {
            answer  = new String[leftIdx];
            for (int i = answer.length - 1; i >= 0; i--) {
                answer[i] = str_list[--leftIdx];
            }
        } else if (rightIdx != -1) {
            answer = new String[str_list.length - rightIdx - 1];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = str_list[++rightIdx];
            }
        }
        return answer;
    }

    public String[] solution(String[] str_list) {

        for (int i = 0; i < str_list.length; i++) {

            if ("l".equals(str_list[i])) {
                return Arrays.copyOfRange(str_list, 0, i);
            } else if ("r".equals(str_list[i])) {
                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
            }
        }

        return new String[0];
    }
}
