package com.codingtest.zerobaseshool.hintsfor2.해시테이블;
// 한 번만 등장한 문자

import java.util.Hashtable;
import java.util.Arrays;
class Solution {
    public static String solution(String s) {
        String answer = "";
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(ht.containsKey(c)){
                ht.put(c, ht.get(c)+1);
            }else {
                ht.put(c, 1);
            }
        }
        StringBuilder str = new StringBuilder();
        for(Character key: ht.keySet()){
            if(ht.get(key)==1){
                str.append(key);
            }
        }
        char[] chrlist = str.toString().toCharArray();   //String자체를 오름차순, 내림차순으로 정렬하는건 못찾음. StringBuilder의 reverse()도 정렬이 아닌 넣었던 순서의 반대로 보여주는 메서드다
        Arrays.sort(chrlist);
        answer = new StringBuilder(new String(chrlist)).toString();

        return answer;
    }

    public static void main(String[] args) {
        String s = "abcabcadc";
        System.out.println(solution(s));
        s = "abdc";
        System.out.println(solution(s));
        s = "hello";
        System.out.println(solution(s));
    }
}
