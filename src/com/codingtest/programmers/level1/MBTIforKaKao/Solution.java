package com.codingtest.programmers.level1.MBTIforKaKao;
/**
* @package : com.codingtest.programmers.level1.MBTIforKaKao
* @name : Solution.java
* @date : 2023-06-13 오후 12:30
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/
import java.util.*;

public class Solution {
    public static String solution(String[] survey, int[] choices) {
        // R/T - C/F - J/M - A/N
        String answer = "";
//        HashMap<String, int[]> map = new HashMap<String,int[]>();
//        map.put("RT", new int[2]);
//        map.put("CF", new int[2]);
//        map.put("JM", new int[2]);
//        map.put("AN", new int[2]);
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        map.put("RT", new ArrayList());
        map.put("CF", new ArrayList());
        map.put("JM", new ArrayList());
        map.put("AN", new ArrayList());

        //List<Integer> list1 = new ArrayList<Integer>();
        int[] list1 = new int[2];


        for(int i=0; i<choices.length; i++){
            int score = 4 - choices[i];
            if(score>0){

            } else if(score<0){

            } else{

            }
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));
        return answer;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choice));
    }
}
