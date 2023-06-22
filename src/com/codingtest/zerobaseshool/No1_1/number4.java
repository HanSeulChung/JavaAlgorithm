package com.codingtest.zerobaseshool.No1_1;
import java.util.HashMap;
import java.util.Collections;
public class number4 {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        Integer maxValue = Collections.max(map.values());
        //System.out.println(maxValue);

        for(char cKey : map.keySet()){
            if(map.get(cKey)==maxValue){
                answer = cKey - '0';
                //System.out.println(cKey);
                break;
            }
        }
        //System.out.println(map);
        return answer;
    }
}

