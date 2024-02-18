package com.codingtest.zerobaseschool.hintsfor2.배열;
// 배열 회전시키기

import java.util.Arrays;
class Solution {
    public static int[] solution(int[] numbers, String direction) {
        int N = numbers.length;
        int[] answer = new int[N];
        switch(direction){
            case "right":
                for(int i =0; i<N-1; i++){
                    answer[i+1] = numbers[i];
                }
                answer[0] = numbers[N-1];
                break;
            case "left":
                for(int i =1; i<N; i++){
                    answer[i-1] = numbers[i];
                }
                answer[N-1] = numbers[0];
                break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(Arrays.toString(solution(numbers,"right")));
        numbers = new int[]{4, 455, 6, 4, -1, 45, 6};
        System.out.println(Arrays.toString(solution(numbers,"left")));
    }
}