package com.codingtest.programmers.level0.등차수열의특정항만더하기;

import java.util.stream.IntStream;

public class Solution {
    static int TOLERANCE;

    public int mySolution(int a, int d, boolean[] included) {
        int answer = a;
        TOLERANCE = d;
        int sum = 0;

        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                System.out.println(answer);
                sum += answer;

            }
            answer += TOLERANCE;
        }
        return sum;
    }

    public int streamSolution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length).map(idx -> included[idx]? a + (idx * d) :0 ).sum();
    }

    public int solution1(int a, int d, boolean[] included) {
        int answer = 0;
        int cnt = 0, cd = 0;
        for(int i = 0; i < included.length;i++){
            if(included[i] == true){
                cnt++;
                cd += i;
            }
        }
        answer = a * cnt + d * cd;
        return answer;
    }
}
