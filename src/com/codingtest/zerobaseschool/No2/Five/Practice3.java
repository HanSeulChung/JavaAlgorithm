package com.codingtest.zerobaseschool.No2.Five;

import java.util.*;
import java.util.stream.Collectors;

public class Practice3{
    public static int solution(int[] cards){
        int answer = 0;
        List<Integer> arraylist = new ArrayList<>();
        arraylist = Arrays.stream(cards).boxed().collect(Collectors.toList());

        while(arraylist.size()>1){
            Collections.sort(arraylist);
            int a = arraylist.get(arraylist.size()-1);
            int b = arraylist.get(arraylist.size()-2);
            arraylist.remove(arraylist.size()-1);
            arraylist.remove(arraylist.size()-1);
            arraylist.add(a-b);
        }
        return answer;

    }

    public static void main(String[] args){
        int[] cards = {4, 8, 6, 1, 2};
        System.out.println(solution(cards));
    }
}

