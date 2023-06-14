package com.codingtest.backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ10818 {

    public static void main(String[] args) {
        int[] answer = new int[2];
        int N =0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] intArr = new int[N];
        for(int i=0; i<N; i++){
            intArr[i] = sc.nextInt();
        }
        int min = intArr[0];
        int max = intArr[0];
        for(int num: intArr){
            if(min>num){
                min = num;
            }
            if(max<num){
                max = num;
            }
        }
        answer[0] = min;
        answer[1] = max;
        System.out.println(Arrays.toString(intArr));
        System.out.println(min+" "+max);

        Arrays.sort(intArr);
        System.out.println(intArr[0] + " " +intArr[N-1]);
    }
}
