package com.codingtest.zerobaseschool.No2.Four;

public class Practice3 {
    public int solution(String S1, String S2) {
        int answer = 1;
        int checkIdx = -1;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int N = S1.length()/2 -1;
        if(!S1.substring(0,N+1).equals(S2.substring(N+1))){
            return 0;
        }
        char[] chararrayS1 = S1.toCharArray();
        sb1.append(chararrayS1[0]);
        for(int i =1; i< chararrayS1.length; i++){
            if(Character.isUpperCase(chararrayS1[i])){
                checkIdx = i;
                break;
            }
            sb1.append(chararrayS1[i]);
        }
        for(int i= checkIdx; i<chararrayS1.length; i++){
            sb2.append(chararrayS1[i]);
        }
        sb1.insert(0,sb2);
        if(!sb1.toString().equals(S2)){
            return 0;
        }

        return answer;
    }
}
