package com.codingtest.programmers.level1.완주하지못한선수;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static String solution(String[] participant, String[] completion) {
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        for(int i = 0; i < participant.length; i++) {
            if(setA.contains(participant[i])) {
                participant[i]= participant[i]+" ";
                i--;
                setA.add(participant[i]);
            } else {
                setA.add(participant[i]);
            }
        }
        for(int i = 0; i < completion.length; i++) {
            if(setB.contains(completion[i])) {
                completion[i]=completion[i]+" ";
                setB.add(completion[i]);
            } else {
                setB.add(completion[i]);
            }
        }
        setA.removeAll(setB);
        setA.toString().replaceAll("[0-9]|\\[|\\]","");
        return setA.toString().replaceAll("\\s","");
    }
    public static void main(String[] args) {
        String[] participant = {"kiki","leo", "kiki", "eden","kiki",};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[] {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[] {"mislav", "stanko", "mislav", "ana"};
        completion = new String[] {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));

    }
    }
