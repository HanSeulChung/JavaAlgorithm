package com.lecture.알고리즘.sorting;
// 힙 정렬

import java.util.Arrays;

public class Main3 {
    public static void heapSort(int[] arr) {
        for (int i = arr.length/2 -1; i >=0 ; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        int leftIdx = parentIdx*2+1;
        int rightIdx = parentIdx*2+2;
        int maxIdx = parentIdx;

        if(leftIdx < size && arr[maxIdx]<arr[leftIdx]){
            maxIdx = leftIdx;
        }

        if(rightIdx < size && arr[maxIdx]<arr[rightIdx]){
            maxIdx = rightIdx;
        }

        if(parentIdx!=maxIdx){
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
