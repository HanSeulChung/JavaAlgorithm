package com.codingtest.zerobaseschool.No3.One;

public class Practice3 {
    public static int solution(int n) {
        int answer = 0;
        if(n<=2){
            return 9;
        }
        if(n%2!=0){
            n+=1;
        }
        int k = n/2 -1;
        answer = (9 * (int)Math.pow(10,k) +9)%1000000007;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(3/2);
        System.out.println();


        int n = 2;
        System.out.println(solution(n));
    }
}
