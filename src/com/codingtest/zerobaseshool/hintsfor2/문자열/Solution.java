package com.codingtest.zerobaseshool.hintsfor2.문자열;
// 문자열안에 문자열
class Solution {
    public static int solution(String str1, String str2) {
        int answer = 0;
        int N = str2.length();

        for(int i =0; i<str1.length(); i++){
            char c = str1.charAt(i);
            if(c==str2.charAt(0) && (i+N)<=str1.length()){
                String checkstriing = str1.substring(i, i+N);
                if(str2.equals(checkstriing)){
                    answer =1;
                    break;
                }
                answer =2;
            } else {
                answer = 2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String str1 = "ab6CDE443fgh22iJKlmn1o";
        String str2 = "6CD";
        System.out.println(solution(str1,str2));

        str1 = "ppprrrogrammers";
        str2 = "pppp";
        System.out.println(solution(str1,str2));

        str1 = "AbcAbcA";
        str2 = "AAA";
        System.out.println(solution(str1,str2));
    }
}
