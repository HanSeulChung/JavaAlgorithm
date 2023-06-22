package com.codingtest.zerobaseshool.No1_1;
// 16점


public class number2 {
    public boolean solution(int num) {
        boolean answer = true;
        int N = num / 3;
        if(num>4){
            if(N%2 ==0){
                answer =false;
            }else if(N%2!=0 && 3*N+2 ==num){
                answer = false;
            }
        }
        return answer;
    }
}
