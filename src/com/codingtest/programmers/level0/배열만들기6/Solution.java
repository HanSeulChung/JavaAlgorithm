package com.codingtest.programmers.level0.배열만들기6;

import java.util.Stack;

public class Solution {
    public int[] mySolution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int idx = 0;
        while(idx < arr.length) {
            if (stk.isEmpty()) {
                stk.push(arr[idx]);
            } else {
                if (stk.peek() == arr[idx]) {
                    stk.pop();
                } else {
                    stk.push(arr[idx]);
                }
            }
            idx++;
        }
        if (stk.isEmpty()) {
            return new int[]{-1};
        }
        int[] answer = new int[stk.size()];
        for (int i = stk.size() - 1; i >= 0; i--) {
            answer[i] = stk.pop();
        }
        return answer;
    }
}
