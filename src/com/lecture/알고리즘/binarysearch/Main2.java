package com.lecture.알고리즘.binarysearch;

// 자바 기본 binarySearch

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(" == 데이터가 있는 경우 ==");
        System.out.println(Arrays.binarySearch(arr, 1));
        System.out.println(Arrays.binarySearch(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 30));

        System.out.println(" == 데이터가 없는 경우 ==");
        System.out.println(Arrays.binarySearch(arr, 3));   //-3 (원래라면 있을만한 위치 2에 마이너스 부호 붙이고 1을 뺀 것)
        System.out.println(Arrays.binarySearch(arr, 11));   //-5
        System.out.println(Arrays.binarySearch(arr, 55));   // -7

    }
}