package com.codingtest.programmers.level0.두수의합;

import java.math.BigInteger;

public class Solution {

    public String solution(String a, String b) {
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);

        return String.valueOf(a1.add(b1));
    }
    public String failSolution(String a, String b) {
        long strA = -1;
        long strB = -1;
        long strA2 = -2;
        long strB2 = -2;

        if (a.length() > 18) {
            strA2 = Long.parseLong(a.substring(a.length () - 18, a.length()));
        } else {
            strA = Long.parseLong(a);
        }
        if (b.length() > 18) {
            strB2 = Long.parseLong(b.substring(b.length () - 18, b.length()));
        } else {
            strB = Long.parseLong(b);
        }
        // 18자리수 > 17승

        if (strA2 == -2 && strB2 == -2) {
            return String.valueOf(strA + strB);
        } else if (strA2 != -2 && strB2 == -2) {
            String strC = String.valueOf(strA2 + strB);
            if (strC.length() > 18) {

            }
            return a.substring(a.length() - 18) + strC;
        } else if (strA2 == -2 && strB2 != -2) {
            String strC = String.valueOf(strA + strB2);
            if (strC.length() > 18) {

            }
            return b.substring(b.length() - 18) + strC;
        } else {
            String strC = String.valueOf(strA2 + strB2);
            if (strC.length() > 18) {

            }
            return b.substring(b.length() - 18) + strC;
        }
    }
}
