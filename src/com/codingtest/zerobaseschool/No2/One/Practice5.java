package com.codingtest.zerobaseschool.No2.One;

public class Practice5 {
    public static int solution(int num) {
        int answer = 0;
        boolean isMinus = false;
        StringBuilder sb = new StringBuilder();
        char[] intchars = ("" + num).toCharArray();
        for(int i =0; i<intchars.length; i++){
            if(intchars[i] =='-'){
                isMinus = true;
                continue;
            } else{
                sb.append(intchars[i]);
            }
        }
        answer = Integer.parseInt(sb.reverse().toString());
        if(isMinus){
            answer *=-1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(-587));
        System.out.println(solution(-780));
        System.out.println(solution(60));
        System.out.println(solution(-100000));
    }
}
