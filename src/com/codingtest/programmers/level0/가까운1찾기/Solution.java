package com.codingtest.programmers.level0.가까운1찾기;

import java.util.stream.IntStream;

public class Solution {
    public int mySolution(int[] arr, int idx) {
        int answer = 0;
        if (arr[idx] == 1) {
            return idx;
        }

        while (idx < arr.length - 1) {

            idx++;
            if (arr[idx] == 1) {
                return idx;
            }
        }

        return -1;
    }

    public int solution(int[] arr, int idx) {
        int answer = -1;
        for(int i = idx; i<arr.length; i++){
            if(arr[i]==1){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public int streamSolution(int[] arr, int idx) {
        return IntStream.range(idx, arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);
    }
}
