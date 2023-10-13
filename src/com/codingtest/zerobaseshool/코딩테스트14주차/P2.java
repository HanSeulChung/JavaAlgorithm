package com.codingtest.zerobaseshool.코딩테스트14주차;

import java.util.*;
public class P2 {
    public boolean isWithinIntegerRange(String str) {
        try {
            int parsedValue = Integer.parseInt(str);
            return parsedValue >= Integer.MIN_VALUE && parsedValue <= Integer.MAX_VALUE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String solution(String s, int k) {

        if (k == s.length()) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        char[] sArray = s.toCharArray();
        List<Integer> zeroList = new ArrayList<>();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == '0') {
                zeroList.add(i);
            }
        }

        int idx = 0;
        if (zeroList.size() != 0) {
            while(k > 0) {
                if (idx >= sArray.length) {
                    break;
                }

                if (zeroList.contains(idx)){
                    idx++;
                    continue;
                }
                sArray[idx++] = '0';
                k--;
            }

            if (isWithinIntegerRange(new String(sArray))){
                int tmp = Integer.parseInt(new String(sArray));
                return String.valueOf(tmp);
            }

            int nonZeroIdx = 0;
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] != '0') {
                    nonZeroIdx = i;
                    break;
                }
            }
            String tmp = new String(sArray);
            return tmp.substring(nonZeroIdx);
        }



        //  else {
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (int i = 0; i < sArray.length; i++) {

        //     }
        // }


        // for (int i = 0; i < sArray.length; i++) {
        //     // if (sArray[i] = '0')
        // }
        return "1";
    }
}
