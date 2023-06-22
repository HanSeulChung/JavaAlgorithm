package com.codingtest.zerobaseshool.No1_1;

public class number5 {
    public int solution(String S) {
        int answer = 0;
        int tenN = 0;
        //System.out.println(S);
        for(int i = 0; i< S.length(); i++){
            char c = S.charAt(i); //
            //System.out.println(c);
            if(c=='1'){
                tenN += Math.pow(2,S.length()-i-1);
                //System.out.print(i+" ");
                //System.out.println(tenN);
            }
        }

        while(tenN!=0){
            if(tenN%2 !=0){
                tenN -=1;
            }else{
                tenN /=2;
            }
            //System.out.println(tenN);
            answer++;
        }

        //System.out.println(tenN);
        return answer;
    }
}
