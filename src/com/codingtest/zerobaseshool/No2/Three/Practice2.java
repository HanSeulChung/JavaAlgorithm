package com.codingtest.zerobaseshool.No2.Three;

import java.util.*;
import java.util.stream.Collectors;

public class Practice2{
    public static int[] solution(int[] nums){
        int[] answer = {};
        HashSet<Integer> hsset = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 1; i<= nums.length; i++){
            if(hsset.add(i)){
                arraylist.add(i);
            }
        }
        answer = arraylist.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 6, 6, 6};
        System.out.println(Arrays.toString(solution(nums)));
    }
}
