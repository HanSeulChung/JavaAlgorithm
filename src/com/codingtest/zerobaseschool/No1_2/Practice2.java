package com.codingtest.zerobaseschool.No1_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice2 {
    public static String[] solution(String s){
        String[] splitstr = s.split("[.,?!\\s]+");
        ArrayList<String> arraylist = new ArrayList<>();
        for (int i = 0; i < splitstr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j =0; j< splitstr[i].length(); j++){
                sb.append(splitstr[i].charAt(j));
            }
            arraylist.add(sb.reverse().toString());

        }
        return arraylist.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String S = "Hello, World!?";
        System.out.println(Arrays.toString(solution(S)));

    }
}
