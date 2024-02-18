package com.codingtest.zerobaseschool.코딩테스트6주차;

import java.util.*;
public class P4 {
    public int[] bestsolution(int[] arr, int k) {
        int[] answer = new int[arr.length - k + 1];

        PriorityQueue<Integer> window = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < Math.min(arr.length, k); i++) {
            window.offer(arr[i]);
        }

        for (int i = 0; i < answer.length - 1; i++) {
            answer[i] = window.peek();
            window.remove(arr[i]);
            window.offer(arr[i + k]);
        }

        answer[arr.length - k] = window.peek();
        return answer;
    }
    public int[] mysolution(int[] arr, int k) {
        int n = arr.length;
        int[] answer = new int[n - k + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = k; i < n; i++) {
            answer[i - k] = maxHeap.peek();
            maxHeap.remove(arr[i - k]);
            maxHeap.offer(arr[i]);
        }

        answer[n - k] = maxHeap.peek();

        return answer;
    }
    public int[] solution(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        PriorityQueue<Integer> window = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            window.offer(arr[i]);
        }
        result[0] = window.peek();

        for (int i = 1; i < result.length; i++) {
            window.remove(arr[i - 1]);
            window.offer(arr[i + k - 1]);
            result[i] = window.peek();
        }
        return result;
    }
}
