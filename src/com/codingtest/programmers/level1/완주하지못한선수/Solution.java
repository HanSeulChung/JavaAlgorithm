package com.codingtest.programmers.level1.완주하지못한선수;

import java.util.*;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> complete = new HashMap<>();
        for (String completParticipant : completion) {
            complete.put(completParticipant,
                complete.getOrDefault(completParticipant, 0) + 1);
        }
        StringBuffer answer = new StringBuffer();
        for (String partPerson : participant) {
            if (!complete.containsKey(partPerson)) {
                answer.append(partPerson);
                break;
            }
            complete.put(partPerson,
                complete.getOrDefault(partPerson, complete.get(partPerson)) - 1);

            if (complete.get(partPerson) == 0) {
                complete.remove(partPerson);
            }
        }

        if (answer.toString().equals("")) {
            answer.append(complete.keySet().iterator().next());
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String[] participant = {"kiki","leo", "kiki", "eden","kiki",};
        String[] completion = {"eden", "kiki"};
        Solution s = new Solution();
        System.out.println(s.solution(participant, completion));

        participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[] {"josipa", "filipa", "marina", "nikola"};
        System.out.println(s.solution(participant, completion));

        participant = new String[] {"mislav", "stanko", "mislav", "ana"};
        completion = new String[] {"stanko", "ana", "mislav"};
        System.out.println(s.solution(participant, completion));

    }
}
