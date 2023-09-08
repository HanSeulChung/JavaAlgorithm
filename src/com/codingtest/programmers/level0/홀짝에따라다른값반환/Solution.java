package com.codingtest.programmers.level0.홀짝에따라다른값반환;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        if (n % 2 != 0) {
            for (int i = 1; i <= n; i = i + 2) {
                answer += i;
            }
        } else {
            for (int i = 2; i <= n; i = i + 2) {
                answer += i * i;
            }
        }
        return answer;
    }

    public int streamSolution(int n) {
        if(n%2 == 0) {
            return IntStream.rangeClosed(1,n)
                    .filter(i -> i % 2 == 0).map(i->(int) Math.pow(i, 2)).sum();
        }
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).sum();
    }
}
