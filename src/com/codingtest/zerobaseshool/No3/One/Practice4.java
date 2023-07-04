package com.codingtest.zerobaseshool.No3.One;

public class Practice4 {
    public static String solution(String s) {
        String answer = "NO";
        int p1 = 0;
        int p2 = 0;
        while (p2+2<s.length()) {
            while (s.charAt(p1) != '1' && p1 < s.length()) {
                p1++;
            }
            p2= p1+2;
            while (s.charAt(p2) !='1'&& p1 < p2) {
                p2++;
            }
            if (p2 - p1 > 2) {
                break;
            }
            p1=p2+1;
            p2= p1+1;
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "111000010100";
        System.out.println(solution(s));
        s = "001001000100";
        System.out.println(solution(s));

    }
}
