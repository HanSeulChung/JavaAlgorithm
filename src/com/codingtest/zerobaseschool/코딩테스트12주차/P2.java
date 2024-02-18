package com.codingtest.zerobaseschool.코딩테스트12주차;

import java.util.Arrays;
import java.util.Stack;

public class P2 {
    public int[] mySolution(int[] arr, int k) {
        int[] answer = new int[arr.length - k + 1];
        int[] median = new int[k];

        int p1 = 0;
        int p2 = 0;
        int idx = 0;

        while(idx < answer.length) {
            int medianIdx = 0;
            while (p2 < p1 + k) {
                median[medianIdx++] = arr[p2++];
            }
            Arrays.sort(median);
            answer[idx++] = median[median.length / 2];
            p1++;
            p2 = p1;
        }


        return answer;
    }

    public int solution(int[] heights) {
        int result = 0;
        int N = heights.length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, heights[0]});

        int[] heightsAug = new int[N+1];
        System.arraycopy(heights, 0, heightsAug, 0, N);
        heightsAug[N] = 0;

        for (int i = 1; i < N+1; i++) {
            int left = i;
            while (!stack.isEmpty() && stack.peek()[1] > heightsAug[i]) {
                int[] ints = stack.pop();
                left = ints[0];
                int temp = ints[1];
                result = Math.max(result, temp * (i - left));
            }
            stack.push(new int[]{left, heightsAug[i]});
        }

        return result;
    }
}