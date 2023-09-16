package com.codingtest.programmers.level0.길이에따른연산;

import java.util.stream.IntStream;

public class Solution {

    public int mySolution(int[] num_list) {
        int answer = 0;
        if (num_list.length >= 11) {
            answer = 0;
            for (int num : num_list) {
                answer += num;
            }
        } else {
            answer = 1;
            for (int num : num_list) {
                answer *= num;
            }
        }
        return answer;
    }

    public int solution1(int[] num_list) {
        IntStream stream = IntStream.of(num_list);
        return num_list.length>10?stream.sum():stream.reduce(1, (a, b) -> a * b);
    }

    public int solution(int[] num_list) {
        int answer = (num_list.length < 11 ? 1 : 0);

        for(int i=0; i<num_list.length; i++){

            if(num_list.length < 11) {
                answer *= num_list[i];
            }else{
                answer += num_list[i];
            }

        }

        return answer;
    }
}
