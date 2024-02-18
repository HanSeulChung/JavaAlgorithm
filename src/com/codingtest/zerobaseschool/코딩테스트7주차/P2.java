package com.codingtest.zerobaseschool.코딩테스트7주차;

public class P2 {
    public int solution(int[] votes) {
        // Boyre-Moore majority vote algorithm
        // O(N) time complexity, O(1) space complexity

        int majority = votes[0];
        int count = 0;

        for (int vote : votes) {
            if (vote == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = vote;
                    count = 1;
                }
            }
        }
        return majority;
    }
}
