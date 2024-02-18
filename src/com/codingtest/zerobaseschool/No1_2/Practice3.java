package com.codingtest.zerobaseschool.No1_2;

public class Practice3 {
    public static int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        return gcd(b, a%b);
    }
    public static int solution(int[] A){
        int answer= 0;
        int gcdNum = gcd(A[0], A[1]);
        for(int i = 2; i<A.length-1; i++){
            gcdNum = gcd(gcdNum, A[i]);
        }
        answer  = gcdNum;
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {6, 12, 4};
        System.out.println(solution(A));

    }
}
