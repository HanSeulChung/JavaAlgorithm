package com.codingtest.zerobaseschool.No2.One;

import java.util.Arrays;

public class Practice2 {
    public static int[] changearr(int[] arr, int idx){
        int[] tmparr = arr.clone();
        if(idx >= arr.length-1 ){
           return arr;
        }
        tmparr[idx+1] = arr[idx];
        for(int i = idx+2; i<arr.length; i++){
            tmparr[i] = arr[i-1];
        }
        return tmparr;
    }
    public static int[] solution(int[] arr) {
        int[] answer = arr.clone();
        for(int i =0; i< arr.length; i++){
            if(answer[i]%2==0){
                continue;
            } else{
               answer = changearr(answer, i);
               i++;
               i++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 4, 3, 0};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
