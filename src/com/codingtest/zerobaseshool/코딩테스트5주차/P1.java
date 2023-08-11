package com.codingtest.zerobaseshool.코딩테스트5주차;

import java.util.Arrays;

public class P1 {
    public static boolean mysolution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];


        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length; i++) {  // -> foreach를 쓰면 early stop을 못함
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}
