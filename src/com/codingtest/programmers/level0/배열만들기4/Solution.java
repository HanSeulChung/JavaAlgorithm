package com.codingtest.programmers.level0.배열만들기4;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int idx = 0;

        while(idx < arr.length) {
            if (stk.isEmpty()) {
                stk.add(arr[idx++]);
            } else {
                int peekValue = stk.peek();
                if (peekValue < arr[idx]) {
                    stk.add(arr[idx++]);
                } else {
                    stk.pop();
                }
            }
        }

        return stk.stream().mapToInt(i -> i).toArray();
    }
}
