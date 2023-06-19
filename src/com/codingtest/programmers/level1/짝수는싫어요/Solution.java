package com.codingtest.programmers.level1.짝수는싫어요;

import java.util.Arrays;
import java.util.stream.IntStream;
;
public class Solution {

    public static int[] streamsolution(int n){
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
    public static int[] solution(int n) {
        int[] answer = {};
        if(n%2==0){
            answer = new int[n/2];
        }else{
            answer = new int[n/2+1];
        }

        int idx = 0;
        for(int i =0; i<=n; i++){
            if(i%2!=0){
                answer[idx++] = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(Arrays.toString(solution(n)));
        System.out.println(streamsolution(n));
    }
}
