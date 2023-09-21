package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.util.PriorityQueue;

public class P2 {

    public int[] solution(int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (i, j) -> {
                    String stri = String.valueOf(i);
                    String strj = String.valueOf(j);
                    if (stri.charAt(0) == strj.charAt(0)) {
                        if (stri.length() != strj.length()) {
                            return stri.length() - strj.length();
                        } else {
                            return i - j;
                        }
                    }
                    return stri.charAt(0) - strj.charAt(0);
                }
        );
        for (int i = 1; i <= n; i++) {
            pq.offer(i);
        }

        return pq.stream().mapToInt(i -> i).toArray();
    }
}
