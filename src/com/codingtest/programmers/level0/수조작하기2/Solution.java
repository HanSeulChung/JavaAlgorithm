package com.codingtest.programmers.level0.수조작하기2;

public class Solution {
    public String mySolution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int prev = numLog[0];
        for (int i = 1; i < numLog.length; i++) {
            int cur = numLog[i];
            switch(cur - prev) {
                case 1:
                    sb.append("w");
                    break;
                case -1:
                    sb.append("s");
                    break;
                case 10:
                    sb.append("d");
                    break;
                case -10:
                    sb.append("a");
                    break;
            }
            prev = cur;
        }
        return sb.toString();
    }
}
