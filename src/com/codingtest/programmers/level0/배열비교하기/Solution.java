package com.codingtest.programmers.level0.배열비교하기;

import java.util.stream.IntStream;

public class Solution {
    public int mySolution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return 1;
        } else if (arr1.length < arr2.length) {
            return -1;
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int arr1Num : arr1) {
            sum1 += arr1Num;
        }

        for (int arr2Num : arr2) {
            sum2 += arr2Num;
        }

        if (sum1 > sum2) {
            return 1;
        } else if (sum1 < sum2) {
            return -1;
        }
        return 0;
    }

    public int solution1(int[] arr1, int[] arr2) {
        int answer = Integer.compare(arr1.length, arr2.length);

        if(answer == 0) {
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }

        return answer;
    }
    public int solution2(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) return -1;
        else if (arr1.length > arr2.length) return 1;
        int arr1Sum = 0, arr2Sum = 0;
        for (int i = 0;i < arr1.length;i++) {
            arr1Sum += arr1[i];
            arr2Sum += arr2[i];
        }
        return arr1Sum == arr2Sum ? 0 : (arr1Sum > arr2Sum ? 1 : -1);
    }
}
