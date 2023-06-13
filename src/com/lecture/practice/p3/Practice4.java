package com.lecture.practice.p3;

import java.util.ArrayList;

public class Practice4 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        if(matrix ==null || matrix.length==0){
            return null;
        }
        int rowNumber = matrix.length;
        int colNumber = matrix[0].length;
        int i =0;
        boolean finishcheck = false;
        ArrayList<Integer> answer = new ArrayList<>();
        while(!finishcheck){
            if(answer.size()== rowNumber*colNumber){
                finishcheck = true;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10 ,11 ,12}};
        System.out.println((solution(matrix)));
    }
}
