package com.lecture.알고리즘.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main6 {
    public static void countingSort(int[] arr) {
        // 방법 1. array의 index를 숫자로 두고 그 인덱스값에 cnt값 넣기 -> 단점 숫자가 커질 경우 인덱스값이 매우 큰 배열을 만들어야함
//        int maxValue = Arrays.stream(arr).max().getAsInt();
//        int[] cntArr = new int[maxValue+1];
//        for (int i = 0; i < arr.length; i++) {
//            cntArr[arr[i]]++;
//        }
//        int idx=0;
//        for (int i = 0; i < cntArr.length; i++) {
//            while(cntArr[i]>0){
//                arr[idx++] = i;
//                cntArr[i] -=1;
//            }
//        }

        // 방법 2. HashMap 이용
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int idx = 0;

        for(int i = 0; i< list.size(); i++){
            int cnt = map.get(list.get(i));
            while(cnt>0){
                arr[idx++] = list.get(i);
                cnt--;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }
}
