package com.lecture.math.combination;

// 기초 수학 - 조합

public class Main {

    public static void getCombination(int n, int r){
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--){
            pResult *= i;
        }

        int rResult = 1;
        for (int i = r; i >= 1; i--){
            rResult *= i;
        }
        System.out.println( pResult/rResult);
    }
    public static void main(String[] args) {
//      1. 조합
        System.out.println("== 조합 ==");

        int n = 4;
        int r = 2;

        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--){
            pResult *= i;
        }

        int rResult = 1;
        for (int i = r; i >= 1; i--){
            rResult *= i;
        }

        System.out.println( pResult/rResult);

//      2. 중복 조합
        System.out.println("== 중복 조합 ==");
        n = 2;
        r = 3;

        getCombination(n + r - 1, r);

    }
}