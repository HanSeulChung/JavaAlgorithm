package com.codingtest.zerobaseschool.No2.One;

import java.util.*;
import java.util.stream.Collectors;

public class Practice4 {
    public static int solution(String s){
        int answer =0;
        String[] strarray = s.split(" ");
        HashSet<String> hsset = new HashSet<>(Arrays.stream(strarray).collect(Collectors.toList()));
        System.out.println(hsset);
        answer = hsset.size();
        return answer;
    }

    public static void main(String[] args){
        String s = "Hello world Nice world";
        System.out.println(solution(s));
    }
}
