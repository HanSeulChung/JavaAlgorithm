package com.codingtest.programmers.level0.다음에올숫자;

public class Solution {
    public int mySolution(int[] common) {
        boolean check = true;
        int value = common[1] - common[0];
        for (int i = 1; i < common.length - 1; i++) {
            if (value != common[i + 1] - common[i]) {
                check = false;
                break;
            }
        }
        if (check) {
            return common[common.length - 1] + value;
        }

        return (common[1] / common[0]) * common[common.length - 1];
    }

    public int solution(int[] common) {
        int answer = 0;

        int x = common[1] - common[0];
        int y = common[2] - common[1];

        if (x == y) {
            answer = common[common.length - 1] + y;
        } else {
            answer = common[common.length - 1] * common[2] / common[1];
        }

        return answer;
    }
}
