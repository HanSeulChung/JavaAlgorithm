package com.codingtest.programmers.level0.옹알이1;

public class Solution {
    public static String[] babblingArray = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (String bab : babbling) {
            for (String babstr : babblingArray) {
                bab = bab.replaceFirst(babstr, " ");
            }
            if (bab.replaceAll(" ", "").equals("")) {
                answer++;
            }
        }
        return answer;
    }

    public int solution1(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
                answer++;
            }
        }
        return answer;
    }

    public int solution2(String[] babbling) {
        int answer = 0;

        for(int i =0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("woo", "1");
            babbling[i] = babbling[i].replace("ye", "1");
            babbling[i] = babbling[i].replace("ma", "1");
            babbling[i] = babbling[i].replace("1", "");
            if(babbling[i].isEmpty()) {
                answer = answer + 1;
            }
        }

        return answer;
    }
}
