package com.lecture.알고리즘.연습문제2;


import java.util.Arrays;

// 이진탐색
public class Practice1 {
    public static int solution(int[] rocks, int goal, int n) {
        if (rocks == null || rocks.length == 0) {
            return -1;
        }

        Arrays.sort(rocks);

        int left = 0;
        int right = goal;

        int result = Integer.MIN_VALUE;
        while (left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }

                if (cnt > n){
                    break;
                }
            }

            if ( goal - prev < mid && cnt <=n ){
                cnt++;
            }

            if (cnt > n){
                right = mid - 1;
            } else {
                left = mid + 1;

                if (cnt == n) {
                    result = Math.max(result, mid);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] rocks = {11, 2, 14, 21, 17};
        int goal = 25;
        int n = 2;
        System.out.println(solution(rocks, goal, n));
    }
}
