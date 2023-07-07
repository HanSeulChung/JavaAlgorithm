package com.lecture.알고리즘.연습문제1;

// 이진탐색
// 0 ~ 최대 시간
// 그 사이의 반값 먼저 search


import java.util.Arrays;

public class Practice1 {
    public static int solution(int n, int[] times) {
        if (times == null || times.length == 0) {
            return -1;
        }

        Arrays.sort(times); // 오름차순이 보장되어있지 않으므로 
        int left = 0;
        int right= times[times.length - 1] * n;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            int cnt = 0;
            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }

            if( cnt < n){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times)); // 답 28
    }
}
