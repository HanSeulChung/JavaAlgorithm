package com.codingtest.zerobaseschool.No2.Two;

import java.util.*;
public class Practice3 {
    public static double solution(String S) {
        double answer = 0;
        String[] numarray = S.split("[+-/*]+");

        String[] signarray = S.split("[0-9]");
        System.out.println(Arrays.toString(numarray));
        System.out.println(Arrays.toString(signarray));
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 1; i<signarray.length; i++){
            if(signarray[i].equals("*")||signarray[i].equals("/")){
                map.put(signarray[i], i);
            }
        }
        List<String> numlist = new ArrayList<>(Arrays.asList(numarray));
        List<String> signlist = new ArrayList<>(Arrays.asList(signarray));

        if(map.size()!=0){
            for(String key : map.keySet()){
                int idx =map.get(key).intValue()-1;
                if(key.equals("*")){

                    numlist.remove(idx+1);
                    numlist.remove(idx);
                    signlist.remove(idx+1);
                    answer = Integer.parseInt(numarray[idx]) *  Integer.parseInt(numarray[idx+1]);
                    numlist.add(idx,String.valueOf(answer));
                } else {
                    numlist.remove(idx+1);
                    numlist.remove(idx);
                    signlist.remove(idx+1);
                    answer = Integer.parseInt(numarray[map.get(key).intValue()-1]) /  Integer.parseInt(numarray[map.get(key).intValue()]);
                }
            }
        }


        for (int i = 1; i < signlist.size(); i++) {
            if(signlist.get(i).equals("-")){
                answer += Integer.parseInt(numlist.get(i-1))-Integer.parseInt(numlist.get(i));
            } else if(signlist.get(i).equals("+")){
                answer += Integer.parseInt(numlist.get(i-1))+Integer.parseInt(numlist.get(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "2-6-7*8/2+15";
        System.out.println(solution(s));
    }
}
