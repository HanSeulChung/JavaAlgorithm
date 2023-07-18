package com.codingtest.programmers.level2.조이스틱;

public class Solution {
    public static int solution(String name) {
        int updown = 0;
        int leftright = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            updown += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A'){
                    endA++;
                }
                leftright = Math.min(leftright, i * 2 + (name.length() - endA));
                leftright = Math.min(leftright, i + (name.length() - endA) * 2);
            }
        }
        return updown + leftright;
    }
    public static void main(String[] args) {

    }
}
