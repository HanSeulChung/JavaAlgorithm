package com.codingtest.zerobaseshool.No2.Two;

import java.util.*;
public class Practice1 {
    public static String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        char[] chararray = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(char charnum: chararray){
            map.put(charnum, map.getOrDefault(charnum,0)+1);
        }
        int startidx = map.size()*2;
        for(int i =0; i<=9; i++){
            char tmpchar = (char)(i+'0');
            map.put((tmpchar), map.getOrDefault(tmpchar,0)+1);
        }

        List<Character> listKeySet = new ArrayList<>(map.keySet());

        Collections.sort(listKeySet, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        for(Character key : listKeySet){
            sb.append(key).append(" ");
        }
        answer = sb.deleteCharAt(sb.length()-1).toString();
        return answer;
    }

    public static void main(String[] args) {
        String s = "2221113333";
        System.out.println(solution(s));
        s = "22211133";
        System.out.println(solution(s));
        s = "100000";
        System.out.println(solution(s));

        s = "1203";
        System.out.println(solution(s));
        s = "12130";
        System.out.println(solution(s));
    }
}
