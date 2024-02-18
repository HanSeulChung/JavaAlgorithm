package com.codingtest.zerobaseschool.No2.Three;

import java.util.*;

public class Practice1{
    public static String solution(String s){
        StringBuilder sb = new StringBuilder();
        char[] chararray = s.toCharArray();
        LinkedHashMap<Character, Integer> lhmap = new LinkedHashMap<>();
        for(char c : chararray){
            lhmap.put(c, lhmap.getOrDefault(c, 0)+1);
        }

        List<Character> listkeySet = new ArrayList<>(lhmap.keySet());
        System.out.println(listkeySet);
        Collections.sort(listkeySet, (v1, v2) -> lhmap.get(v2).compareTo(lhmap.get(v1)));
        System.out.println(listkeySet);
        for(Character charkey: listkeySet){
            sb.append(charkey).append(" ");
        }
        for(int i =0; i<=9; i++){
            char c = (char)(i+'0');
            if(!lhmap.containsKey(c)){
                sb.append(c).append(" ");
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static void main(String[] args){
        String s = "221123333";
        System.out.println(solution(s));
    }
}


//
//import java.util.*;
//
//class Solution {
//    public String solution(String s) {
//        String answer = "";
//        StringBuilder sb = new StringBuilder();
//
//        char[] chararray = s.toCharArray();
//        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//        for(char charnum: chararray){
//            map.put(charnum, map.getOrDefault(charnum,0)+1);
//        }
//
//        for(int i =0; i<=9; i++){
//            char tmpchar = (char)(i+'0');
//            map.put((tmpchar), map.getOrDefault(tmpchar,0)+1);
//        }
//
//        List<Character> listKeySet = new ArrayList<>(map.keySet());
//
//        Collections.sort(listKeySet, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
//
//        for(Character key : listKeySet){
//            sb.append(key).append(" ");
//        }
//        answer = sb.deleteCharAt(sb.length()-1).toString();
//        return answer;
//    }
//}
