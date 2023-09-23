package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.util.*;

public class P2 {
    List<Integer> resultList;

    public void dfs(int num , int n) {
        if (num > n) {
            return;
        }

        if (num > 0) {
            resultList.add(num);
        }

        for (int i = 0; i < 10; i++) {
            int newNum = num * 10 + i;
            if (newNum == 0) {
                continue;
            }
            dfs(newNum, n);
        }
    }

    public int[] solution(int n) {
        resultList = new ArrayList<>();
        dfs(0, n);
        return resultList.stream().mapToInt(i -> i).toArray();
    }



    public int[] failSolution(int n) {

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
