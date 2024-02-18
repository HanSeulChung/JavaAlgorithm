package com.codingtest.zerobaseschool.No2.Four;

public class Practice1{
    public static int solution(int N, int K) {
        int answer = 0;
        int cnt = 0;
        while(N>0){
            N = N/10;
            cnt++;
        }
//        while(cnt>0){
//
//        }
        System.out.println(cnt);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(120, 2));
    }
}