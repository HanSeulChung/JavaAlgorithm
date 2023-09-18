package com.codingtest.programmers.level0.zero떼기;

public class Solution {
    public String mySolution(String n_str) {
        char[] charArr = n_str.toCharArray();
        int idx = -1;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != '0') {
                idx = i;
                break;
            }
        }

        return n_str.substring(idx, n_str.length());
    }

    public String solution1(String n_str) {
        return ""+Integer.parseInt(n_str);
    }

    public String solution2(String nStr) {
        return String.valueOf(Integer.parseInt(nStr));
    }
}
