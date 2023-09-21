package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.util.*;

public class P4 {
    public int solution(int money, int[] chips) {
        Integer[] sortedChips = Arrays.stream(chips).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedChips, Collections.reverseOrder());

        int change = money;
        int cnt = 0;
        for (int i = 0; i < sortedChips.length; i++) {
            if (change < sortedChips[i]) {
                continue;
            }

            cnt += change / sortedChips[i];
            change %= sortedChips[i];
        }
        return cnt;
    }

}
