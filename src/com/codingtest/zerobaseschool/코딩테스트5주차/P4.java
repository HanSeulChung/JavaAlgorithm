package com.codingtest.zerobaseschool.코딩테스트5주차;

import java.util.Arrays;

public class P4 {
    public static int mysolution(int N, int[] branches) {
        int answer = -1;

        int minLen = 1;
        int maxLen = 0;
        for (int branch : branches) {
            maxLen = Math.max(maxLen, branch);
        }

        while (minLen <= maxLen) {
            int midLen = (minLen + maxLen) / 2;
            int count = 0;
            for (int branch : branches) {
                count += branch / midLen;
            }

            if (count >= N) {
                answer = midLen;
                minLen = midLen + 1;
            } else {
                maxLen = midLen - 1;
            }
        }

        return answer;
    }

    public static int solution(int N, int[] branches) {
        int left = 1;
        int right = Arrays.stream(branches).max().getAsInt();
        int best = -1;

        Arrays.sort(branches);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int total = 0;
            for (int i = branches.length - 1; i >= 0; i--) {
                total += branches[i] / mid;

                if (total >= N) { // 최적화
                    break;
                }
            }

            if (total >= N) {
                best = Math.max(best, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return best;
    }
}
