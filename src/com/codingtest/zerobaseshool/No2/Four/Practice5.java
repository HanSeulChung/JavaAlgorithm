package com.codingtest.zerobaseshool.No2.Four;

import java.util.*;

public class Practice5{
    public static int check(String str, String s){
    int checktmp = 0;
    boolean check = true;
    for(int i =0; i<str.length(); i++){
        char strc = str.charAt(i);
        char sc = s.charAt(i);
        if(strc != sc){
            check =false;
            break;
        } else {
            checktmp +=1;
        }
    }
    if(checktmp == str.length() && check){
        checktmp = 1;
    } else{
        return 0;
    }
    return checktmp;
}
    public static int solution(String[] array, String s){
        int answer = 0;
        for(String str : array){
            if(str.length() < s.length()){
                int tmp = check(str, s);
                answer += tmp;
            } else if(str.length()== s.length() && str.equals(s)){
                answer+=1;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[] s = {"n", "nav", "nev"};
        String str1 = "naver";
        System.out.println(solution(s, str1));
    }
}
