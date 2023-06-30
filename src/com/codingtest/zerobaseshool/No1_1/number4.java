package com.codingtest.zerobaseshool.No1_1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
public class number4 {
    public static int solution1(String s){
        int answer = -1;
        int tmp = -1;
        int[] arr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c-'0']++;
        }
        for(int i =0; i<arr.length; i++){
            if(arr[i]>tmp){
                tmp = arr[i];
                answer = i;
            }
        }
        //System.out.println(Arrays.toString(arr));
        return answer;

    }
    public static int solution(String s) {
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

    public static void main(String[] args) {
        String s =  "174771177";
        System.out.println(solution1(s));
        s = "552342502";
        System.out.println(solution1(s));
    }
}

