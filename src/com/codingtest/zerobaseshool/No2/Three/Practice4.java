package com.codingtest.zerobaseshool.No2.Three;

public class Practice4 {
    public static int solution(int A, int B) {
        int answer = 0;
        int C = A^B;
        String binaryC = Integer.toBinaryString(C);
        char[] chararray = binaryC.toCharArray();
        for(char charnum: chararray){
            if(charnum=='1'){
                answer+=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int A = 29;
        int B = 15;
        System.out.println(solution(A,B));
    }
}