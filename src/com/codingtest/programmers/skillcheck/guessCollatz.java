package com.codingtest.programmers.skillcheck;

import java.util.*;
public class guessCollatz {
    public static double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        int idx = 0;
        do{
            if(k%2==0){
                k=k/2;
            } else{
                k=k*3+1;
            }
            idx++;

        }while(k!=1);

        System.out.println(idx);

        return answer;
    }
    public static void main(String[] args) {
        int k=5;
        int[][] ranges = {{0,0}, {0,-1},{2,-3},{3,-3}};
        double[] answer=solution(k,ranges);
        System.out.println(Arrays.toString(answer));

    }
}
