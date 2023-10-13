package com.codingtest.zerobaseshool.montly6;

import java.util.*;

public class P2 {
    public int[] solution(int N, int K, int[] arr, int[][] queries) {
        if(N != arr.length || K != queries.length) {
            return new int[0];
        }

        Arrays.sort(arr);
        int maxValue = arr[N - 1];
        int minValue = arr[0];

        List<Integer> list = new ArrayList<>();

        for(int[] query : queries){
            int cnt = 0;

            int X = query[0];
            int Y = query[1];

            if (Y >= maxValue && X <= minValue) {
                cnt = N;
            } else if (X == Y) {
                cnt = N;
            } else {
                for (int number : arr) {
                    if (number >= X && number <= Y) {
                        cnt++;
                    }
                }
            }

            list.add(cnt);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
