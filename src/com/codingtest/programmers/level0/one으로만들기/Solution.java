package com.codingtest.programmers.level0.one으로만들기;

import java.util.Arrays;

public class Solution {
    public int mySolution(int[] num_list) {
        int answer = 0;
        for (int num : num_list) {
            while( num != 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = (num - 1) / 2;
                }
                answer++;
            }
        }
        return answer;
    }

    public int solution1(int[] num_list) {
        int answer = 0;
        for(int i = 0;num_list.length>i;i++){
            while(num_list[i]!=1){
                num_list[i]/=2;
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int[] num_list) {
        return Arrays.stream(num_list)
                .map(num -> {
                    int count = 0;

                    while (num != 1) {
                        num = (num % 2 == 0) ? num / 2 : (num - 1) / 2;
                        count++;
                    }

                    return count;
                })
                .sum();
    }

    public int solution3(int[] num_list) {
        return Arrays.stream(num_list).map(i -> Integer.toBinaryString(i).length() - 1).sum();
    }
}
