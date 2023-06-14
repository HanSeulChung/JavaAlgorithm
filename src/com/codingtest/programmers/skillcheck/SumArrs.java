package com.codingtest.programmers.skillcheck;

import java.util.*;
public class SumArrs {

    public int[][] solution2(int[][] arr1, int[][] arr2) {
        // m*k * k*n --> m*n
        int[][] answer = new int[arr1.length][arr2[0].length];
        // System.out.println(answer.length); // 3
        // System.out.println(answer[0].length); // 2

        // i : answer.length == 3
        // j : answer[0].length == 2
        // k : arr2.length == 2
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                int sum = 0;
                for(int k = 0; k < arr2.length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                    //System.out.println("i : " + i + "  j : " + j + "  k : " + k + "  sum : " + sum);
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
   public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int row =0;

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4},{3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1},{3, 1, 1}};
        int[][] answer = solution(arr1,arr2);
        for(int[] row: answer){
            for(int col:row){
                //System.out.println(col);
            }
        }
    }
}
