package com.codingtest.programmers.level0.n개간격의원소들;

public class Solution {
    public int[] mySolution(int[] num_list, int n) {
        int[] answer = {};
        if (num_list.length % n == 0) {
            answer = new int[num_list.length / n ];
        } else {
            answer = new int[(num_list.length / n) + 1];
        }

        int idx = 0;
        for (int i = 0; i < num_list.length; i += n) {
            answer[idx++] = num_list[i];
        }
        return answer;
    }

    public int[] solution(int[] num_list, int n) {
        Double length = Math.ceil(num_list.length/(n*1.0));
        int[] answer = new int[length.intValue()];

        for(int idx=0; idx<length; idx++) {
            answer[idx] = num_list[idx*n];
        }

        return answer;
    }
}
