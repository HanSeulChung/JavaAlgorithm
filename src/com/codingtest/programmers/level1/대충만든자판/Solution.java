package com.codingtest.programmers.level1.대충만든자판;

import java.util.*;
public class Solution {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(String str:keymap){
            for(int i =0; i<str.length(); i++){
                char c = str.charAt(i);
                if(!map.containsKey(c)){
                    map.put(c,i+1);
                } else if(map.containsKey(c) && i+1 < map.get(c)){
                    map.put(c,i+1);
                }
            }
        }
        int answerIdx = 0;
        for(String targetstr: targets){
            int cnt = 0;
            for(int i =0; i < targetstr.length(); i++){
                char c = targetstr.charAt(i);
                if(map.containsKey(c)){
                    cnt += map.get(c);
                } else{
                    cnt = -1;
                }
            }
            answerList.add(cnt);
        }
        answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        System.out.println(solution(keymap,targets));

        keymap = new String[]{"AA"};
        targets = new String[]{"B"};
        System.out.println(solution(keymap,targets));

        keymap = new String[]{"AGZ", "BSSS"};
        targets = new String[]{"ASA","BGZ"};
        System.out.println(solution(keymap,targets));
    }
}
