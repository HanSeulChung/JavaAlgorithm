package com.lecture.자바기초.자바기초practice.p3;


import java.util.Arrays;
import java.util.HashSet;

public class Practice1 {
    // Set 사용해서 풀이
    public static void solution(int[] nums) {
        Integer[] integernums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        HashSet<Integer> numSet = new HashSet<Integer>(Arrays.asList(integernums));
        //System.out.println(numSet);
        for(int a: numSet){
            System.out.print(a +" ");
        }
        System.out.println();
    }
    // Array 하나만 이용해서 풀이
    public static void solution1(int[] nums) {
        int idx = 0;
        for(int num: nums){
            if(idx==0 || num>nums[idx-1]){
                nums[idx++] =num;
            }
        }
        //System.out.println(nums);
        for(int i =0; i<idx; i++){
            System.out.print(nums[i] +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println();
        solution1(new int[] {1, 1, 2});
        solution1(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
