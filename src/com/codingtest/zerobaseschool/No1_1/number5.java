package com.codingtest.zerobaseschool.No1_1;

public class number5 {
    public static int soluiton1(String S){
        int answer = 0;
        int num = Integer.parseInt(S,2);
        while(num!=0){
            if(num%2==0){
                num/=2;
            } else{
                num-=1;
            }
            answer++;
        }


        return answer;
    }
    public static int solution(String S) {
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

    public static void main(String[] args) {
        String S = "1101";
        System.out.println(soluiton1(S));
    }
}
