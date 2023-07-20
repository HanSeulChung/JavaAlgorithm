package com.lecture.선형자료구조.practices2;


import java.util.Hashtable;

public class Practice4 {
    public static String solution(String[] participant, String[] completion) {
        String result = "";
        Hashtable<String, Integer> ht = new Hashtable<>();

        for (String item : participant) {
            if (ht.containsKey(item)) {
                ht.put(item, ht.get(item) + 1);
            } else {
                ht.put(item, 1);
            }
        }

        for (String item : completion) {
            ht.put(item, ht.get(item) - 1);
        }

        for (String item : participant) {
            if (ht.get(item) > 0) { // 단 한명의 완주하지 못한 선수이기 때문에 단순하고 쉬웠다. 조금 어렵게 꼰다면 나는 풀 수 있을까?
                result = item;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}

