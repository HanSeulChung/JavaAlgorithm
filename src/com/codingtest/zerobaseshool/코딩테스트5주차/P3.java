package com.codingtest.zerobaseshool.코딩테스트5주차;

public class P3 {
    public static int mysolution(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == 0 || left == arr.length - 1) {
            return -1;
        }

        return left;
    }

    public static int solution(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid - 1] < arr[mid]) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    left = mid;
                }
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
