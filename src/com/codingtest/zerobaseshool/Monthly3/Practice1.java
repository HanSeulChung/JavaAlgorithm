package com.codingtest.zerobaseshool.Monthly3;

import java.util.*;

public class Practice1 {
    public int solution(int[] arrive, int[] patience) {
        int answer = 0;
        int person = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arrive.length; i++){
            if(map.containsKey(arrive[i])){
                answer = answer + 2;
                map.remove(arrive[i]);
            }
            map.put(arrive[i], i);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int p1 = 0;
        while(p1<list.size()-1){
            if(person == 2){
                p1 = p1 + 2;
                person= 0;
                answer = answer + 2;
            }
            else if (list.get(p1)+patience[map.get(list.get(p1))] >= list.get(p1+1)){
                person = 2;
            } else {
                p1++;
            }
        }

        return answer;
    }
}