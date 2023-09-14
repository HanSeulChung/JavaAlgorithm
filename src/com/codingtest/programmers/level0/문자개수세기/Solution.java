package com.codingtest.programmers.level0.문자개수세기;

/**
 * A : 65 ~ Z: 90 > 총 26개
 * a : 97 ~ z :122 > 총 26개
 */
public class Solution {
    public int[] mySolution(String my_string) {
        int[] answer = new int[26 + 26];

        for (int i = 0; i < my_string.length(); i++) {
            int asciiIdx = (byte)my_string.charAt(i);
            if(my_string.charAt(i) >= 'A' && my_string.charAt(i) <= 'Z') {
                answer[asciiIdx - 65]++;
            } else if (my_string.charAt(i) >= 'a' && my_string.charAt(i) <= 'z') {
                answer[asciiIdx - 71]++;
            }
        }
        return answer;
    }

    public int[] solution1(String my_string) {
        int[] answer = new int[52];
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c >= 'a')
                answer[c - 'a' + 26]++;
            else
                answer[c - 'A']++;
        }
        return answer;
    }

    public int[] solution2(String my_string) {
        int[] answer = new int[52];

        for (char c : my_string.toCharArray()) {
            if (Character.isUpperCase(c)) answer[c - 65]++;
            else answer[c - 71]++;
        }

        return answer;
    }
}
