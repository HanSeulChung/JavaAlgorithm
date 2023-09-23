package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.util.*;

public class P4 {
    public int solution(int money, int[] chips) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < money + 1; i++) {
            for (int j = 0; j < chips.length; j++) {
                if (i - chips[j] < 0) {
                    continue;
                }
                if (dp[i - chips[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i] , dp[i - chips[j]] + 1);
                }
            }
        }
        return dp[money];
    }

}
