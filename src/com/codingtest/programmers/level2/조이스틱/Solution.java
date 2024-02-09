package com.codingtest.programmers.level2.조이스틱;

public class Solution {
    public int solution(String name) {
        int updown = 0;
        int n = name.length();
        int leftright = n - 1;

        for (int idx = 0; idx < n; idx++) {
            updown += Math.min(name.charAt(idx) - 'A', 26 - (name.charAt(idx) - 'A'));

            if (idx < n - 1 && name.charAt(idx + 1) == 'A') {
                int endA = idx + 1;
                while(endA < n && name.charAt(endA) == 'A') {
                    endA++;
                }
                leftright = Math.min(leftright, idx * 2 + n - endA);
                leftright = Math.min(leftright, idx + (n - endA) * 2);
            }
        }
        return updown + leftright;
    }
}
