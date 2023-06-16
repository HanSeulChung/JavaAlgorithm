package com.lecture.자바기초.자바기초practice.p3;

import java.util.ArrayList;

public class Practice2 {
    public static ArrayList<Integer> solution(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();
        int realIdx = 0;
        while(realIdx<nums.length){
            int fakeIdx = Math.abs(nums[realIdx])-1;
            if(nums[fakeIdx]<0){
                answer.add((Integer)Math.abs(fakeIdx+1));
            }
            else{
                nums[fakeIdx]=-nums[fakeIdx];
            }
            realIdx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1, 3, 5, 5};
        System.out.println(solution(nums));
    }
}
