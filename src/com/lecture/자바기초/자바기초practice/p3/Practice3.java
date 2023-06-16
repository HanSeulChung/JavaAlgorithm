package com.lecture.자바기초.자바기초practice.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Practice3 {
    public static void solution(int[] arr, int k, int x) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for( int i=0; i < arr.length; i++){
            int diff = Math.abs(k-arr[i]);

            ArrayList<Integer> cur = map.get(diff);
            if(cur==null){
                map.put(diff, new ArrayList<>(Arrays.asList(arr[i])));
            } else {
                int idx = cur.size();
                for (int j =0; j <cur.size(); j++){
                    if(cur.get(j) > arr[i]){
                        idx = j;
                        break;
                    }
                }
                cur.add(idx, arr[i]);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt =0;
        while(map.size()>0){
            int minDiff = map.keySet().stream().min((a,b) -> a - b).get();
            ArrayList<Integer> cur = map.get(minDiff);
            map.remove(minDiff);

            while(cur.size()>0){
                answer.add(cur.get(0));
                cur.remove(0);
                cnt++;

                if(cnt==k){
                    break;
                }
            }
            if(cnt==k){
                break;
            }
        }
        Collections.sort(answer);
        System.out.println(answer);
    }
    public static void solution1(int[] arr, int k, int x) {
        int standardIdx = 0;
        boolean check = false;
        for(int num : arr){
            if(num==x){
                check=true;
                break;
            }
            standardIdx++;
        }
        // 기준 값 x가 배열 arr에 있는 경우
        if(check){
            if(k%2!=0){ //k가 홀수일 경우: (k-1)/2+ 기준 + (k-1)/2
                for(int i=standardIdx-(k-1)/2; i<= standardIdx+ (k-1)/2; i++){
                    System.out.print(arr[i]+" ");
                }
            }
            else{       //k가 짝수일 경우:
                if(k>arr.length){ // k가 arr길이보다 더 클 경우
                    for(int el:arr){
                        System.out.print(el+ ' ');
                    }
                }
                else{ // k가 arr길이보다 작을 경우
                    for(int i=standardIdx-(k/2); i<standardIdx+(k/2); i++){
                        System.out.print(arr[i]+" ");
                    }
                }
            }
        }
        // 기준 값 x가 배열 arr에 없는 경우
        else{
            if(k>arr.length){ //개수 k가 arr보다 많을 경우
                for(int answer: arr){
                    System.out.print(answer +" ");
                }
            }
            else{ //개수 k가 arr보다 적을 경우
                for(int i=0; i<k; i++){
                    System.out.print(arr[i]+" ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr, 4, 3);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution(arr, 5, 5);

        arr = new int[]{2, 4};
        solution(arr, 1, 3);

        arr = new int[]{2, 4};
        solution(arr, 3, 3);

        System.out.println();

        int[] arr1 = {1, 2, 3, 4, 5};
        solution1(arr1, 4, 3);

        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution1(arr1, 5, 5);

        arr1 = new int[]{2, 4};
        solution1(arr, 1, 3);

        arr1 = new int[]{2, 4};
        solution1(arr1, 3, 3);
    }
}
