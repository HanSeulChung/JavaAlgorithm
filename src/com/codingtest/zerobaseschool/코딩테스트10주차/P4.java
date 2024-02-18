package com.codingtest.zerobaseschool.코딩테스트10주차;

public class P4 {

    public boolean solution(int[] nums) {
        // 어디까지 우측을 갈 수 있다면, (최대 우측)을 기억하고
        // 활용하자

        // 최대 이용가능한 위치를 매번 갱신
        // 최대 가능한 위치를 기준으로 왼쪽으로는 모두 이용 가능하기 때문에 DP!

        int N = nums.length;
        int maxIdx = 0;

        for (int i = 0; i < N; i++) {
            // 현재 위치에 도달이 가능하다면 최대 위치를 업데이트
            if (maxIdx >= i) {
                maxIdx = Math.max(maxIdx, i + nums[i]);

                // 끝에 도달할수있으면 긑
                if (maxIdx >= N - 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
